# java设计模式-工厂模式
## 什么是工厂模式
> 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。

## 工厂模式的优点
> 1. 良好的封装性，降低模块的耦合性。利用工厂模式，我们可以不在关注类的创建过程，只需要知道创建的条件,不需要关注过程，就可以获得所需对象
> 2. 高扩展性。如果要扩展新的功能，只需要新生成一个工厂类或者扩展，就可以完成。像jdbc链接池，对应不同的驱动，只需要扩展驱动，不需要动其他东西。

## 工厂模式的缺点
> 没有一个事物是完美的，拥有那么多优点的工厂模式又有哪些缺点呢?
> - 增加新的产品等级结构很复杂，需要修改抽象工厂和所有的具体工厂类，对“开闭原则”的支持呈现倾斜性。在一开始我们需要大量的编码工作去组合工厂，这就增加了很多工作量

## 工厂模式的应用场景
> - 相同功能，不同处理方式的场景。比如：日志，jdbc

## 工厂模式代码样例
> 样例背景：简单的设计一个，生产不同的名字，在中文中有姓和名，名字都是随机生成的，那么姓呢，在中文中姓可是有很多的，所以我们可以利用工厂模式，来构建不同姓的名字。

抽象工厂类：
```
abstract String buildName(Class<? extends SurnameInterface> clas) throws IllegalAccessException, InstantiationException;

     public static String getChinese() {
        String str = null;
        int highPos, lowPos;
        Random random = new Random();
         //区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
        highPos = (176 + Math.abs(random.nextInt(71)));
        random=new Random();
         //位码，0xA0打头，范围第1~94列
        lowPos = 161 + Math.abs(random.nextInt(94));

        byte[] bArr = new byte[2];
        bArr[0] = (new Integer(highPos)).byteValue();
        bArr[1] = (new Integer(lowPos)).byteValue();
        try {
            //区位码组合成汉字
            str = new String(bArr, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
```
[代码链接]()

工厂实现类：
```
@Override
    String buildName(Class<? extends SurnameInterface> clas) throws IllegalAccessException, InstantiationException {
        SurnameInterface surnameInterface=clas.newInstance();
        String surname=surnameInterface.getSurname();
        String name=surname+getChinese();
        System.out.println(name);
        return name;
    }
```
[代码链接]()

生产类接口：
```
public interface SurnameInterface {

    String getSurname();
}
```
[代码链接]()

生产类实现：
```
public class ZhaoSurname implements SurnameInterface {
    @Override
    public String getSurname() {
        return "赵";
    }
}
```
```
public class ZhengSurname implements SurnameInterface {


    @Override
    public String getSurname() {
        return "郑";
    }
}
```
[代码链接]()

Main：
```
 public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        AbsrractFactory absrractFactory=new NameFactiry();
        absrractFactory.buildName(ZhengSurname.class);
        absrractFactory.buildName(ZhaoSurname.class);
    }
```
[代码链接]()

这样我们需要新增一个姓，只需要构建一个生产类，就可以不动原代码结构，做到我们想要做的事情

## 工厂模式代码UML类图


