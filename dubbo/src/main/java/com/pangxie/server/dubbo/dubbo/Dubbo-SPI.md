# Dubbo(一)-SPI（2） 机制之 Dubbo 的 SPI

### Dubbo 的 SPI 是什么

> [下文描述来自官网介绍](http://dubbo.apache.org/zh-cn/docs/dev/SPI.html):
>
> Dubbo 的扩展点加载从 JDK 标准的 SPI (Service Provider Interface) 扩展点发现机制加强而来。
>
> Dubbo 改进了 JDK 标准的 SPI 的以下问题：
>
> - JDK 标准的 SPI 会一次性实例化扩展点所有实现，如果有扩展实现初始化很耗时，但如果没用上也加载，会很浪费资源。
> - 如果扩展点加载失败，连扩展点的名称都拿不到了。比如：JDK 标准的 ScriptEngine，通过 getName() 获取脚本类型的名称，但如果 RubyScriptEngine 因为所依赖的 jruby.jar 不存在，导致 RubyScriptEngine 类加载失败，这个失败原因被吃掉了，和 ruby 对应不起来，当用户执行 ruby 脚本时，会报不支持 ruby，而不是真正失败的原因。
> - 增加了对扩展点 IoC 和 AOP 的支持，一个扩展点可以直接 setter 注入其它扩展点。

### Dubbo 的 SPI 核心文件目录

![dubbo-spi文件目录](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/spi/dubbo/dubbo.spi.struct.png)
没错就只有那么一点，是不是觉得很神奇。具体介绍内容前，先介绍下文件作用

#### 注解部分

1. @SPI

   该注解是标记接口是扩展接口,也就是说想要使用 Dubbo 的 SPI 就必须打上这个注解。

   ```
   @Documented
   @Retention(RetentionPolicy.RUNTIME)
   @Target({ElementType.TYPE})
   public @interface SPI {

   /**
    * default extension name
    */
   String value() default "";

   }
   ```

   value 的作用是标记 spi 扩展所需要的对应类的。和上篇 javaSpi 作用其实是一样的，只不过 dubbo 弄了个标示可以选择不同的值，以 xxx=xxxx 的形式选择

   e.g:![dubbo-spi文件目录](https://raw.githubusercontent.com/fightcrap/javaStudy/master/image/spi/dubbo/dubbo.spi.resources.png)

2. @Adaptive

   该注解是整个功能的核心，它的作用有两个：

   - 作用在类上面，这代表该实现类是唯一承认的接口实现类，也就是哪怕我在@SPI 注解上指定了对应的实现类，也是不认哒
   - 作用在方法上(这个需要和@SPI 注解连用),而且参数中必须有一个 org.apache.dubbo.common.URL 才行,Dubbo 会对应生成一个 xxx\$Adaptive 类,作为一个中间类，用于选择提供不同的实现类。

   ```
   @Documented
   @Retention(RetentionPolicy.RUNTIME)
   @Target({ElementType.TYPE, ElementType.METHOD})
   public @interface Adaptive {

       String[] value() default {};

   }
   ```

3. @Activate

   该注解是扩展点自动激活加载的注解，就是用条件来控制该扩展点实现是否被自动激活加载，在扩展实现类上面使用。

#### 接口实现部分

1. ExtensionFactory

   SPI 利用工厂模式来实现各功能，其中前言也讲到过，Dubbo 的 SPI 增加了对扩展点 IoC 和 AOP 的支持，这个工厂也是实现这个的基础，它有 3 个实现类：AdaptiveExtensionFactory，SpiExtensionFactory 和 SpringExtensionFactory。同样该接口也是被@SPI 修饰的，所以它也是可以扩展的，但是 AdaptiveExtensionFactory 有@Adaptive 实现，所以它是唯一作用的。它把所有
   ExtensionFactory 的实现获取了，通过遍历的形式，执行两种不同的获取方式，兼容了 Spring 框架的形式
   ExtensionFactory:

   ```
   @SPI
   public interface ExtensionFactory {

       /**
       * Get extension.
       *
       * @param type object type.
       * @param name object name.
       * @return object instance.
       */
       <T> T getExtension(Class<T> type, String name);

   }
   ```

   AdaptiveExtensionFactory:

   ```
   public AdaptiveExtensionFactory() {
       ExtensionLoader<ExtensionFactory> loader = ExtensionLoader.getExtensionLoader(ExtensionFactory.class);
       List<ExtensionFactory> list = new ArrayList<ExtensionFactory>();
       for (String name : loader.getSupportedExtensions()) {
           list.add(loader.getExtension(name));
       }
       factories = Collections.unmodifiableList(list);
   }

   @Override
   public <T> T getExtension(Class<T> type, String name) {
       for (ExtensionFactory factory : factories) {
           T extension = factory.getExtension(type, name);
           if (extension != null) {
               return extension;
           }
       }
       return null;
   }
   ```

   SpiExtensionFactory:

   ```
   public class SpiExtensionFactory implements ExtensionFactory {

   @Override
   public <T> T getExtension(Class<T> type, String name) {
       if (type.isInterface() && type.isAnnotationPresent(SPI.class)) {
           ExtensionLoader<T> loader = ExtensionLoader.getExtensionLoader(type);
           if (!loader.getSupportedExtensions().isEmpty()) {
               return loader.getAdaptiveExtension();
           }
       }
       return null;
   }

   }
   ```

   SpringExtensionFactory:

   ```
   public <T> T getExtension(Class<T> type, String name) {

       //SPI should be get from SpiExtensionFactory
       if (type.isInterface() && type.isAnnotationPresent(SPI.class)) {
           return null;
       }

       for (ApplicationContext context : contexts) {
           if (context.containsBean(name)) {
               Object bean = context.getBean(name);
               if (type.isInstance(bean)) {
                   return (T) bean;
               }
           }
       }

       logger.warn("No spring extension (bean) named:" + name + ", try to find an extension (bean) of type " + type.getName());

       if (Object.class == type) {
           return null;
       }

       for (ApplicationContext context : contexts) {
           try {
               return context.getBean(type);
           } catch (NoUniqueBeanDefinitionException multiBeanExe) {
               logger.warn("Find more than 1 spring extensions (beans) of type " + type.getName() + ", will stop auto injection. Please make sure you have specified the concrete parameter type and there's only one extension of that type.");
           } catch (NoSuchBeanDefinitionException noBeanExe) {
               if (logger.isDebugEnabled()) {
                   logger.debug("Error when get spring extension(bean) for type:" + type.getName(), noBeanExe);
               }
           }
       }

       logger.warn("No spring extension (bean) named:" + name + ", type:" + type.getName() + " found, stop get bean.");

       return null;
   }
   ```

   ok 全部 dubbo 的 spi 文件内容就是如此，我们在看一下运行的细则

### Dubbo 的 SPI 运行流程

1. 运行入口：

```
 ExtensionLoader<SayWord> loader = ExtensionLoader.getExtensionLoader(SayWord.class);
```

调用 ExtensionLoader 获取 ExtensionLoader 对象。这个方法主要是获取对应 SPI 接口的 ExtemsionLoader。

```
public static <T> ExtensionLoader<T> getExtensionLoader(Class<T> type) {
        if (type == null)
            throw new IllegalArgumentException("Extension type == null");
        if(!type.isInterface()) {
            throw new IllegalArgumentException("Extension type(" + type + ") is not interface!");
        }
        if(!withExtensionAnnotation(type)) {
            throw new IllegalArgumentException("Extension type(" + type +
                    ") is not extension, because WITHOUT @" + SPI.class.getSimpleName() + " Annotation!");
        }

        ExtensionLoader<T> loader = (ExtensionLoader<T>) EXTENSION_LOADERS.get(type);
        if (loader == null) {
            EXTENSION_LOADERS.putIfAbsent(type, new ExtensionLoader<T>(type));
            loader = (ExtensionLoader<T>) EXTENSION_LOADERS.get(type);
        }
        return loader;
    }
```

根据源码我们可以看到，首先会进行条件判断，如果 Class 对象不是接口，而且没有 SPI 注解，则返回异常。如果符合要求，就会在 EXTENSION_LOADERS 对象中获取，如果已经缓存了，则返回缓存的对象，如果没有缓存，则新建 new 一个 ExtensionLoader 对象。EXTENSION_LOADERS 是一个 ConcurrentMap<Class<?>, ExtensionLoader<?>>。是一层缓存。

来看一下创建一个 ExtensionLoader 对象做了什么。这是一个私有构造函数哦，只允许内部创建。

```
private ExtensionLoader(Class<?> type) {
        this.type = type;
        objectFactory = (type == ExtensionFactory.class ? null : ExtensionLoader.getExtensionLoader(ExtensionFactory.class).getAdaptiveExtension());
    }
```

这里无非就是设置了 type，objectFactory 对象。一般情况下我们设置 spi 对象都不会是 ExtensionFactory，所以大部分都会走后面逻辑，会优先建立 ExtensionFactory 的 ExtensionLoader 对象。

_getAdaptiveExtension()做了啥？_：

这个方法其实就是获取了 spi 对应实现形式，类似的还有 getActivateExtension()。其实这个很好理解，分别对应了我们两个注解的功能：@Adaptive 和@Activate。Spi 核心还是 getAdaptiveExtension()方法。

```
public T getAdaptiveExtension() {
        Object instance = cachedAdaptiveInstance.get();
        if (instance == null) {
            if(createAdaptiveInstanceError == null) {
                synchronized (cachedAdaptiveInstance) {
                    instance = cachedAdaptiveInstance.get();
                    if (instance == null) {
                        try {
                            instance = createAdaptiveExtension();
                            cachedAdaptiveInstance.set(instance);
                        } catch (Throwable t) {
                            createAdaptiveInstanceError = t;
                            throw new IllegalStateException("fail to create adaptive instance: " + t.toString(), t);
                        }
                    }
                }
            }
            else {
                throw new IllegalStateException("fail to create adaptive instance: " + createAdaptiveInstanceError.toString(), createAdaptiveInstanceError);
            }
        }

        return (T) instance;
    }
```

让我们来看看具体是啥样子的：优先判断缓存的 hoder 是否存在，在没有调用过这个方法之前，该对象只是创立了个空对象：

```
private final Holder<Object> cachedAdaptiveInstance = new Holder<Object>();
```

所以第一次获取的是空。那么会进入逻辑判断内部，然后判断是否存在异常，会把第一次创建的异常会缓存进。所以这边会缓存 Adaptive 实现对象或者就是异常对象。
再继续看，利用了同步锁二重判断，来确保并发的安全性，然后调用 createAdaptiveExtension()方法来创建。然后缓存了结果。下面是 createAdaptiveExtension（）实现

```
 private T createAdaptiveExtension() {
        try {
            return injectExtension((T) getAdaptiveExtensionClass().newInstance());
        } catch (Exception e) {
            throw new IllegalStateException("Can not create adaptive extenstion " + type + ", cause: " + e.getMessage(), e);
        }
    }
```

会优先调用 getAdaptiveExtensionClass()方法然后实例化。其中流程很简单，最核心的部分为:getAdaptiveExtensionClass()->getExtensionClasses()->loadExtensionClasses();
loadExtensionClasses()主要是加载spi中的类文件，这部分就和正常是spi一样了
```
private Map<String, Class<?>> loadExtensionClasses() {
        final SPI defaultAnnotation = type.getAnnotation(SPI.class);
        if(defaultAnnotation != null) {
            String value = defaultAnnotation.value();
            if(value != null && (value = value.trim()).length() > 0) {
                String[] names = NAME_SEPARATOR.split(value);
                if(names.length > 1) {
                    throw new IllegalStateException("more than 1 default extension name on extension " + type.getName()
                            + ": " + Arrays.toString(names));
                }
                if(names.length == 1) cachedDefaultName = names[0];
            }
        }
        
        Map<String, Class<?>> extensionClasses = new HashMap<String, Class<?>>();
        loadFile(extensionClasses, DUBBO_INTERNAL_DIRECTORY);
        loadFile(extensionClasses, DUBBO_DIRECTORY);
        loadFile(extensionClasses, SERVICES_DIRECTORY);
        return extensionClasses;
    }
```
而在getExtensionClasses()方法中：
```
private Class<?> getAdaptiveExtensionClass() {
        getExtensionClasses();
        if (cachedAdaptiveClass != null) {
            return cachedAdaptiveClass;
        }
        return cachedAdaptiveClass = createAdaptiveExtensionClass();
    }
```
如果存在cachedAdaptiveClass就会返回这个，所以这个也就是未什么@Adaptive注解就是唯一标示了(其中cachedAdaptiveClass的产生在loadFile方法里。可以看看）

如果没有cachedAdaptiveClass就会创建一个，
```
private Class<?> createAdaptiveExtensionClass() {
        String code = createAdaptiveExtensionClassCode();
        ClassLoader classLoader = findClassLoader();
        com.alibaba.dubbo.common.compiler.Compiler compiler = ExtensionLoader.getExtensionLoader(com.alibaba.dubbo.common.compiler.Compiler.class).getAdaptiveExtension();
        return compiler.compile(code, classLoader);
    }
```
这边核心的部分就是 createAdaptiveExtensionClassCode()了，来看看里面实现啥
```
private String createAdaptiveExtensionClassCode() {
        StringBuilder codeBuidler = new StringBuilder();
        Method[] methods = type.getMethods();
        boolean hasAdaptiveAnnotation = false;
        for(Method m : methods) {
            if(m.isAnnotationPresent(Adaptive.class)) {
                hasAdaptiveAnnotation = true;
                break;
            }
        }
        // 完全没有Adaptive方法，则不需要生成Adaptive类
        if(! hasAdaptiveAnnotation)
            throw new IllegalStateException("No adaptive method on extension " + type.getName() + ", refuse to create the adaptive class!");
        
        codeBuidler.append("package " + type.getPackage().getName() + ";");
        codeBuidler.append("\nimport " + ExtensionLoader.class.getName() + ";");
        codeBuidler.append("\npublic class " + type.getSimpleName() + "$Adpative" + " implements " + type.getCanonicalName() + " {");
        
        for (Method method : methods) {
            Class<?> rt = method.getReturnType();
            Class<?>[] pts = method.getParameterTypes();
            Class<?>[] ets = method.getExceptionTypes();

            Adaptive adaptiveAnnotation = method.getAnnotation(Adaptive.class);
            StringBuilder code = new StringBuilder(512);
            if (adaptiveAnnotation == null) {
                code.append("throw new UnsupportedOperationException(\"method ")
                        .append(method.toString()).append(" of interface ")
                        .append(type.getName()).append(" is not adaptive method!\");");
            } else {
                int urlTypeIndex = -1;
                for (int i = 0; i < pts.length; ++i) {
                    if (pts[i].equals(URL.class)) {
                        urlTypeIndex = i;
                        break;
                    }
                }
                // 有类型为URL的参数
                if (urlTypeIndex != -1) {
                    // Null Point check
                    String s = String.format("\nif (arg%d == null) throw new IllegalArgumentException(\"url == null\");",
                                    urlTypeIndex);
                    code.append(s);
                    
                    s = String.format("\n%s url = arg%d;", URL.class.getName(), urlTypeIndex); 
                    code.append(s);
                }
                // 参数没有URL类型
                else {
                    String attribMethod = null;
                    
                    // 找到参数的URL属性
                    LBL_PTS:
                    for (int i = 0; i < pts.length; ++i) {
                        Method[] ms = pts[i].getMethods();
                        for (Method m : ms) {
                            String name = m.getName();
                            if ((name.startsWith("get") || name.length() > 3)
                                    && Modifier.isPublic(m.getModifiers())
                                    && !Modifier.isStatic(m.getModifiers())
                                    && m.getParameterTypes().length == 0
                                    && m.getReturnType() == URL.class) {
                                urlTypeIndex = i;
                                attribMethod = name;
                                break LBL_PTS;
                            }
                        }
                    }
                    if(attribMethod == null) {
                        throw new IllegalStateException("fail to create adative class for interface " + type.getName()
                        		+ ": not found url parameter or url attribute in parameters of method " + method.getName());
                    }
                    
                    // Null point check
                    String s = String.format("\nif (arg%d == null) throw new IllegalArgumentException(\"%s argument == null\");",
                                    urlTypeIndex, pts[urlTypeIndex].getName());
                    code.append(s);
                    s = String.format("\nif (arg%d.%s() == null) throw new IllegalArgumentException(\"%s argument %s() == null\");",
                                    urlTypeIndex, attribMethod, pts[urlTypeIndex].getName(), attribMethod);
                    code.append(s);

                    s = String.format("%s url = arg%d.%s();",URL.class.getName(), urlTypeIndex, attribMethod); 
                    code.append(s);
                }
                
                String[] value = adaptiveAnnotation.value();
                // 没有设置Key，则使用“扩展点接口名的点分隔 作为Key
                if(value.length == 0) {
                    char[] charArray = type.getSimpleName().toCharArray();
                    StringBuilder sb = new StringBuilder(128);
                    for (int i = 0; i < charArray.length; i++) {
                        if(Character.isUpperCase(charArray[i])) {
                            if(i != 0) {
                                sb.append(".");
                            }
                            sb.append(Character.toLowerCase(charArray[i]));
                        }
                        else {
                            sb.append(charArray[i]);
                        }
                    }
                    value = new String[] {sb.toString()};
                }
                
                boolean hasInvocation = false;
                for (int i = 0; i < pts.length; ++i) {
                    if (pts[i].getName().equals("com.alibaba.dubbo.rpc.Invocation")) {
                        // Null Point check
                        String s = String.format("\nif (arg%d == null) throw new IllegalArgumentException(\"invocation == null\");", i);
                        code.append(s);
                        s = String.format("\nString methodName = arg%d.getMethodName();", i); 
                        code.append(s);
                        hasInvocation = true;
                        break;
                    }
                }
                
                String defaultExtName = cachedDefaultName;
                String getNameCode = null;
                for (int i = value.length - 1; i >= 0; --i) {
                    if(i == value.length - 1) {
                        if(null != defaultExtName) {
                            if(!"protocol".equals(value[i]))
                                if (hasInvocation) 
                                    getNameCode = String.format("url.getMethodParameter(methodName, \"%s\", \"%s\")", value[i], defaultExtName);
                                else
                                    getNameCode = String.format("url.getParameter(\"%s\", \"%s\")", value[i], defaultExtName);
                            else
                                getNameCode = String.format("( url.getProtocol() == null ? \"%s\" : url.getProtocol() )", defaultExtName);
                        }
                        else {
                            if(!"protocol".equals(value[i]))
                                if (hasInvocation) 
                                    getNameCode = String.format("url.getMethodParameter(methodName, \"%s\", \"%s\")", value[i], defaultExtName);
                                else
                                    getNameCode = String.format("url.getParameter(\"%s\")", value[i]);
                            else
                                getNameCode = "url.getProtocol()";
                        }
                    }
                    else {
                        if(!"protocol".equals(value[i]))
                            if (hasInvocation) 
                                getNameCode = String.format("url.getMethodParameter(methodName, \"%s\", \"%s\")", value[i], defaultExtName);
                            else
                                getNameCode = String.format("url.getParameter(\"%s\", %s)", value[i], getNameCode);
                        else
                            getNameCode = String.format("url.getProtocol() == null ? (%s) : url.getProtocol()", getNameCode);
                    }
                }
                code.append("\nString extName = ").append(getNameCode).append(";");
                // check extName == null?
                String s = String.format("\nif(extName == null) " +
                		"throw new IllegalStateException(\"Fail to get extension(%s) name from url(\" + url.toString() + \") use keys(%s)\");",
                        type.getName(), Arrays.toString(value));
                code.append(s);
                
                s = String.format("\n%s extension = (%<s)%s.getExtensionLoader(%s.class).getExtension(extName);",
                        type.getName(), ExtensionLoader.class.getSimpleName(), type.getName());
                code.append(s);
                
                // return statement
                if (!rt.equals(void.class)) {
                    code.append("\nreturn ");
                }

                s = String.format("extension.%s(", method.getName());
                code.append(s);
                for (int i = 0; i < pts.length; i++) {
                    if (i != 0)
                        code.append(", ");
                    code.append("arg").append(i);
                }
                code.append(");");
            }
            
            codeBuidler.append("\npublic " + rt.getCanonicalName() + " " + method.getName() + "(");
            for (int i = 0; i < pts.length; i ++) {
                if (i > 0) {
                    codeBuidler.append(", ");
                }
                codeBuidler.append(pts[i].getCanonicalName());
                codeBuidler.append(" ");
                codeBuidler.append("arg" + i);
            }
            codeBuidler.append(")");
            if (ets.length > 0) {
                codeBuidler.append(" throws ");
                for (int i = 0; i < ets.length; i ++) {
                    if (i > 0) {
                        codeBuidler.append(", ");
                    }
                    codeBuidler.append(pts[i].getCanonicalName());
                }
            }
            codeBuidler.append(" {");
            codeBuidler.append(code.toString());
            codeBuidler.append("\n}");
        }
        codeBuidler.append("\n}");
        if (logger.isDebugEnabled()) {
            logger.debug(codeBuidler.toString());
        }
        return codeBuidler.toString();
    }
```
那么大一串其实就是生成了一个class的代码。这边看一下生成的样子是啥样子的
```
package com.pangxie.server.dubbo.dubbo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class SayWord$Adpative implements com.pangxie.server.dubbo.dubbo.spi.api.SayWord {
    @Override
    public java.lang.String saySomething(java.lang.String arg0, com.alibaba.dubbo.common.URL arg1) {
        if (arg1 == null) throw new IllegalArgumentException("url == null");
        com.alibaba.dubbo.common.URL url = arg1;
        String extName = url.getParameter("say.word", "en");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.pangxie.server.dubbo.dubbo.spi.api.SayWord) name from url(" + url.toString() + ") use keys([say.word])");
        com.pangxie.server.dubbo.dubbo.spi.api.SayWord extension = (com.pangxie.server.dubbo.dubbo.spi.api.SayWord) ExtensionLoader.getExtensionLoader(com.pangxie.server.dubbo.dubbo.spi.api.SayWord.class).getExtension(extName);
        return extension.saySomething(arg0, arg1);
    }
}
```
其中，标示了@SPI中的value值就会变成这边的默认值。也就是如果没有设计URL内容，那么返回的都是默认spi的接口。
所以总共的流程就是如此了。接下来看看不同情况的运行结果。在来理解下生成的class代码的运行。

### Dubbo 的 xxx$Adpative 不同运行

测试代码如下

[接口](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/dubbo/spi/api/SayWord.java)：
```
@SPI
public interface SayWord {

    @Adaptive
    String saySomething(String message,URL url);
}
```
[实现1](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/dubbo/spi/impl/SayChineseWord.java)：
```
public class SayChineseWord implements SayWord {
    @Override
    public String saySomething(String message, URL url) {
        return "你好啊";
    }
}
```
[实现2](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/dubbo/spi/impl/SayEnglishWord.java)：
```
public class SayEnglishWord implements SayWord {
    @Override
    public String saySomething(String message, URL url) {
        return "Hello";
    }
}

```
[配置文件](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/resources/META-INF/dubbo/internal/com.pangxie.server.dubbo.dubbo.spi.api.SayWord):
```
cn=com.pangxie.server.dubbo.dubbo.spi.impl.SayChineseWord
en=com.pangxie.server.dubbo.dubbo.spi.impl.SayEnglishWord
```

[运行入口](https://github.com/fightcrap/javaStudy/blob/master/dubbo/src/main/java/com/pangxie/server/dubbo/dubbo/spi/Main.java)：
```
public class Main {

    public static void main(String[] args) {
        ExtensionLoader<SayWord> loader = ExtensionLoader.getExtensionLoader(SayWord.class);
        SayWord sayWord=loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test");
        System.out.println(sayWord.saySomething("d", url));
    }
}

```

1. @Adaptive没有默认值,@SPI没有默认值，URL没有值
```
package com.pangxie.server.dubbo.dubbo.spi.api;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
public class SayWord$Adpative implements com.pangxie.server.dubbo.dubbo.spi.api.SayWord {
public java.lang.String saySomething(java.lang.String arg0, com.alibaba.dubbo.common.URL arg1) {
if (arg1 == null) throw new IllegalArgumentException("url == null");
com.alibaba.dubbo.common.URL url = arg1;
String extName = url.getParameter("say.word");
if(extName == null) throw new IllegalStateException("Fail to get extension(com.pangxie.server.dubbo.dubbo.spi.api.SayWord) name from url(" + url.toString() + ") use keys([say.word])");
com.pangxie.server.dubbo.dubbo.spi.api.SayWord extension = (com.pangxie.server.dubbo.dubbo.spi.api.SayWord)ExtensionLoader.getExtensionLoader(com.pangxie.server.dubbo.dubbo.spi.api.SayWord.class).getExtension(extName);
return extension.saySomething(arg0, arg1);
}
}
```
生成的代码为上诉所示;其实结果我们已经可以猜想到，spi没有默认值，url中也没有标示。所以结果肯定是啥都找不到的
```
Exception in thread "main" java.lang.IllegalStateException: Fail to get extension(com.pangxie.server.dubbo.dubbo.spi.api.SayWord) name from url(test://localhost/test) use keys([say.word])
	at com.pangxie.server.dubbo.dubbo.spi.api.SayWord$Adpative.saySomething(SayWord$Adpative.java)
	at com.pangxie.server.dubbo.dubbo.spi.Main.main(Main.java:33)
```

2. @Adaptive没有默认值,@SPI没有默认值，URL有值
```
package com.pangxie.server.dubbo.dubbo.spi.api;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
public class SayWord$Adpative implements com.pangxie.server.dubbo.dubbo.spi.api.SayWord {
public java.lang.String saySomething(java.lang.String arg0, com.alibaba.dubbo.common.URL arg1) {
if (arg1 == null) throw new IllegalArgumentException("url == null");
com.alibaba.dubbo.common.URL url = arg1;
String extName = url.getParameter("say.word");
if(extName == null) throw new IllegalStateException("Fail to get extension(com.pangxie.server.dubbo.dubbo.spi.api.SayWord) name from url(" + url.toString() + ") use keys([say.word])");
com.pangxie.server.dubbo.dubbo.spi.api.SayWord extension = (com.pangxie.server.dubbo.dubbo.spi.api.SayWord)ExtensionLoader.getExtensionLoader(com.pangxie.server.dubbo.dubbo.spi.api.SayWord.class).getExtension(extName);
return extension.saySomething(arg0, arg1);
}
}
```
生成代码如上诉所示。猜猜看结果，
```
你好啊
Disconnected from the target VM, address: '127.0.0.1:64482', transport: 'socket'

Process finished with exit code 0
```
输出了我们以cn为主的实现类的结果。所以如果没有设置默认值，我们可以利用URL设置的方式，来进行选择，而且这边也有一个好处，就是可以动态选择。只需要通过设置URL的值,就可以避免编码修改的方式，比原来的灵活十足。

2. @Adaptive没有默认值,@SPI有默认值，URL有值
设置SPI默认值为en，URL为cn
```
package com.pangxie.server.dubbo.dubbo.spi.api;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
public class SayWord$Adpative implements com.pangxie.server.dubbo.dubbo.spi.api.SayWord {
public java.lang.String saySomething(java.lang.String arg0, com.alibaba.dubbo.common.URL arg1) {
if (arg1 == null) throw new IllegalArgumentException("url == null");
com.alibaba.dubbo.common.URL url = arg1;
String extName = url.getParameter("say.word", "en");
if(extName == null) throw new IllegalStateException("Fail to get extension(com.pangxie.server.dubbo.dubbo.spi.api.SayWord) name from url(" + url.toString() + ") use keys([say.word])");
com.pangxie.server.dubbo.dubbo.spi.api.SayWord extension = (com.pangxie.server.dubbo.dubbo.spi.api.SayWord)ExtensionLoader.getExtensionLoader(com.pangxie.server.dubbo.dubbo.spi.api.SayWord.class).getExtension(extName);
return extension.saySomething(arg0, arg1);
}
}
```
生成源码如上述所示
```
你好啊
Disconnected from the target VM, address: '127.0.0.1:64614', transport: 'socket'

Process finished with exit code 0

```
最终结果以url的key值为主哦。


## 总结
该文章讲解了dubbo的SPI扩展机制的实现原理，最关键的是弄清楚dubbo跟jdk在实现SPI的思想上做了哪些改进和优化，解读dubbo SPI扩展机制最关键的是弄清楚@SPI、@Adaptive、@Activate三个注解的含义，大部分逻辑都被封装在ExtensionLoader类中。dubbo的spi学习下来让我感觉一点就是灵活性是在是太突出了，不仅仅是根据注解，也可以根据参数形式，利用创建中间包装类，使用装饰模式，来加强spi的灵活。根据上一节其实我们可以知道dubbo选择spi内容的顺序为 @Adaptive》URL》SPI默认值。