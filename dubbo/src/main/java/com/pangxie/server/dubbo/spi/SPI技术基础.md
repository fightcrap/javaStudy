# Dubbo(一)-SPI 机制之javaSPI基础

## 一 、java 的 SPI 机制

### SPI 是什么

> SPI 全称 Service Provider Interface，是 Java 提供的一套用来被第三方实现或者扩展的 API，它可以用来启用框架扩展和替换组件。是“接口的编程＋策略模式＋配置文件”组合实现的动态加载机制

流程架构图：
![spi框架流程图](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/spi/SPI.png)

**在 java 代码中，我们编写接口实现类，往往是事先确定的，在启动时候加载类具体的实现类，一旦我们需要变更选择某一实现类，我们就需要修改代码。为了实现这一个可以动态的选择实现的方式，就出现了 SPI 技术，简单说：SPI 其实就是一种服务发现机制。其核心思想就是结偶**

### SPI 的应用场景

> - 日志模块之日志门面，可以选择不同的实现进行加载
> - 数据库驱动加载接口实现类的加载 JDBC 加载不同类型数据库的驱动
> - Dubbo 中的服务发现机制

### SPI 的使用

SPI 的应用分 4 步:

> 1. 创建接口类
> 2. 编写接口实现类
> 3. 编辑配置文件。
> 4. 程序运行起来

全他妈废话

- 第一步创建接口类，我们这边先定义一个 SayWord 的接口，定义了一个 saySomething 的方法。可以说不同的话语。[SayWord 接口代码](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/spi/api/SayWord.java)

```
public interface SayWord {
    String saySomething();
}
```

- 第二步创建实现类，我这边定义类两个实现，一个是中文的，一个是英文的。
  [SayChineseWord 实现代码](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/spi/impl/SayChineseWord.java)

```
public class SayChineseWord implements SayWord {
    @Override
    public String saySomething() {
        return "你好啊";
    }
}
```

[SayEnglishWord 实现代码](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/spi/impl/SayEnglishWord.java)

```
public class SayEnglishWord implements SayWord {
    @Override
    public String saySomething() {
        return "Hello";
    }
}
```

- 第三步，编写配置文件， 配置文件是有严格的要求的，第一 ：文件位置：META-INF/services 下面，而且目录必须是在 classPath 下面，不然就找不到了。原因后续会解释。 第二：文件名：必须和接口名称一致（包括包路径）。第三：文件内容：实现类的  名称（包括包路径　）
  [文件路径](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/resources/META-INF/services/com.pangxie.server.dubbo.spi.api.SayWord)

```
com.pangxie.server.dubbo.spi.impl.SayChineseWord
com.pangxie.server.dubbo.spi.impl.SayEnglishWord
```

- 全部 ok 后就可以写程序跑起来了～～～
  [Main 代码](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/spi/Main.java)

```
ServiceLoader<SayWord> sayWords=ServiceLoader.load(SayWord.class);
        for(SayWord sayWord:sayWords){
            System.out.println(sayWord.saySomething());
        }
```

### 原理解释
其实从代码编写中可以明白，核心类是ServiceLoader，这个是一个加载服务的一个类，那么具体是怎么实现的呢？来让我们look一下　

成员组成：
大致分为5个成员遍量，分别为:service-接口class对象；loader-类加载器；acc-创建时候用来控制访问权限的上下文;providers-服务实现类列表;lookupIterator-懒加载的迭代器
```
// The class or interface representing the service being loaded
    private final Class<S> service;

    // The class loader used to locate, load, and instantiate providers
    private final ClassLoader loader;

    // The access control context taken when the ServiceLoader is created
    private final AccessControlContext acc;

    // Cached providers, in instantiation order
    private LinkedHashMap<String,S> providers = new LinkedHashMap<>();

    // The current lazy-lookup iterator
    private LazyIterator lookupIterator;
```

提供了唯一的一个静态方法(使用都是它～，或者直接构造吧～)：
```
 public static <S> ServiceLoader<S> load(Class<S> service) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return ServiceLoader.load(service, cl);
    }

```

为嘛路径要是META-INF/services下？在看源码就发现了路径配置：
```
private static final String PREFIX = "META-INF/services/";
```

**load调用发生了啥？其实没啥，就是构建了一个LazyIterator对象，然后就没有然后了。所以构建的时候并没有直接加载，只是存储了基本信息。**
```
public void reload() {
        providers.clear();
        lookupIterator = new LazyIterator(service, loader);
    }
```

只有在调用迭代器的时候，判断是否有有配置调用hasNextService方法会获取实例信息，但是这一步没有加载。
```
if (configs == null) {
                try {
                    String fullName = PREFIX + service.getName();
                    if (loader == null)
                        configs = ClassLoader.getSystemResources(fullName);
                    else
                        configs = loader.getResources(fullName);
                } catch (IOException x) {
                    fail(service, "Error locating configuration files", x);
                }
            }
```
在next方法中判断有实例信息后就利用Class.forName,并且实例化，后存储在链表里。
```
 String cn = nextName;
            nextName = null;
            Class<?> c = null;
            try {
                c = Class.forName(cn, false, loader);
            } catch (ClassNotFoundException x) {
                fail(service,
                     "Provider " + cn + " not found");
            }
            if (!service.isAssignableFrom(c)) {
                fail(service,
                     "Provider " + cn  + " not a subtype");
            }
            try {
                S p = service.cast(c.newInstance());
                providers.put(cn, p);
                return p;
            } catch (Throwable x) {
                fail(service,
                     "Provider " + cn + " could not be instantiated",
                     x);
            }
```

### 总结
- 优点：SPI还是很简单的，基于配置来改变实现类。避免了直接修改代码的情况，做到接口形式的解偶。就可以实现在不同情况下使用不同的框架来。
- 缺点：
多个并发多线程使用ServiceLoader类的实例是不安全的。
需要使用迭代器才会加载，感觉怪怪的。

### 来写一个ServiceLoader吧～
为了熟悉ServiceLoader的实现就随便自己写了一个，可以通过网络请求形式获取配置，简单的扩展下啦啦啦，再加个配置文件变更监听，就可以真的随心所欲了！！！
[代码连接](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/spi/loader/NewServiceLoader.java)
```
public class NewServiceLoader<S> {
    private static final String PREFIX = "META-INF/services/";

    private String prefix = "META-INF/services/";

    /**
     * 接口的class
     */
    private final Class<S> service;

    /**
     * 类加载器
     */
    private final ClassLoader loader;

    /**
     * 权限上下文
     */
    private final AccessControlContext acc;

    /**
     * 提供者列表
     */
    private LinkedHashMap<String, S> providers = new LinkedHashMap<>();

    private HashSet<String> providersName = new HashSet<>();


    private NewServiceLoader(Class<S> svc, String prefix, ClassLoader cl) {
        service = Objects.requireNonNull(svc, "Service interface cannot be null");
        loader = (cl == null) ? ClassLoader.getSystemClassLoader() : cl;
        acc = (System.getSecurityManager() != null) ? AccessController.getContext() : null;
        this.prefix = prefix;
        reload();
    }

    public static <S> NewServiceLoader<S> load(Class<S> sClass, String urlFix) {
        return new NewServiceLoader<S>(sClass, urlFix, null);
    }

    public static <S> NewServiceLoader<S> load(Class<S> sClass) {
        return new NewServiceLoader<S>(sClass, PREFIX, null);
    }

    public static <S> NewServiceLoader<S> load(Class<S> sClass, ClassLoader classLoader) {
        return new NewServiceLoader<S>(sClass, PREFIX, classLoader);
    }


    public LinkedHashMap<String, S> getProviders() {
        //如果两者长度不一致，说明没有加载全实例，需要加载实例
        if (providers.size() != providersName.size()) {
            instanceClass(providersName, providers, service);
        }
        return providers;
    }

    public void setProviders(LinkedHashMap<String, S> providers) {
        this.providers = providers;
    }

    /**
     * 重新加载
     */
    private void reload() {
        //清除一下，然后解析url文件
        providers.clear();
        providersName.clear();
        parse();
    }

    /**
     * 解析文件内容
     */
    private void parse() {
        //加载远程的或者当前的url
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getUrlInfo()));
            String line=null;
            while ((line=bufferedReader.readLine())!=null) {
                providersName.add(line);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 获取路径文件的资源
     * @return
     * @throws IOException
     */
    private InputStream getUrlInfo() throws IOException {
        //如果不是http开头的，那么是类文件路径啦～
        if (!prefix.startsWith("http")) {
            return getClass().getClassLoader().getResource(prefix + service.getName()).openStream();

        }
        // TODO 区分本地机器文件
        URL url = new URL(prefix + service.getName());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        InputStream inStream = conn.getInputStream();
        return inStream;

    }


    /**
     * 实例化变量
     *
     * @param providersName
     * @param providers
     * @param sClass
     */
    private void instanceClass(HashSet<String> providersName, LinkedHashMap<String, S> providers, Class<S> sClass) {
        for (String className : providersName) {
            Class c = null;
            Object instance = null;
            try {
                c = Class.forName(className);
                instance = c.newInstance();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }

            //转化类对象
            S s = sClass.cast(instance);
            providers.put(className, s);
        }
    }

}

```
[新的Main代码](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/spi/NewServiceLoaderMain.java)：
```
public static void main(String[] args) {
        NewServiceLoader<SayWord> sayWords=NewServiceLoader.load(SayWord.class);
        LinkedHashMap<String,SayWord> linkedHashMap=sayWords.getProviders();
        for(SayWord sayWord:linkedHashMap.values()){
            System.out.println(sayWord.saySomething());
        }
    }
```