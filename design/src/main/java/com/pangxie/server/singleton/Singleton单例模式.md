# java设计模式-单例模式
## 什么是单例模式
>单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一,又称：原子模式。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

## 单例模式的优点
> - 减少了内存的开销。由于内存中只有一个实例，就减少了对象的创建、销毁的开销，而且目前对于对象创建、销毁是没办法进行性能优化的。
> - 减少了性能上面的开销。单例模式可以在开始的时候就初始化相关操作，并且保留在内存中，这样就减少了系统运行的性能开销，比如配置的读取能，可以减少io上面频繁的操作。
> - 可以共享资源。我们可以把单例模式设置成系统的全局访问点，可以优化和共享资源的访问。比如，加密工具类

## 单例模式的缺点
> 没有一个事物是完美的，拥有那么多优点的单例模式又有哪些缺点呢?
> - 扩展能力低。由于接口和抽象类是不能被初始化的，所以单例模式一般都是对象类。在一定情况下，单例模式可以被继承和实现接口。但是能被做单例的都不会说接口
> - 违反了单一职责原则。是否单例是根据环境来决定，而不是根据职责来控制，单例会把业务逻辑混合在里面。

## 单例模式的应用场景
> - 要求只有单一对象，出现多个对象会有问题，比如，唯一序列号生成器。
> - 资源共享访问点。可以减少性能的开销
> - 需要大量静态变量或方法（工具类）

## 单例模式的线程安全
> 由于内存中只有一个对象，那么多方都会调用该对象，就很容易出现线程安全问题，一般方法内创建的变量不会有问题，核心是单例本身和单例的全局变量。
```
public class UnsafeSingleton {

    private static UnsafeSingleton unsafeSingleton;

    /**
     * 私有构造器，限制外部不能实例
     */
    private UnsafeSingleton() {

    }

    public static UnsafeSingleton getInstance() {
        if (unsafeSingleton == null) {
            unsafeSingleton = new UnsafeSingleton();
        }
        return unsafeSingleton;
    }
}
```
[代码链接]https://github.com/fightcrap/javaStudy/blob/master/design/src/main/java/com/pangxie/server/singleton/UnsafeSingleton.java)
> 代码解析：这是一个不安全的单例模式，属于懒加载模式的单例。为嘛说这个是不安全的呢？在多线程环境中，线程A来调用getInstance方法，发现没有实例化，则会进入判断括号体中，进行初始化，我们知道，对象实例化的时候,会出现重排序问题，会先分配空间，但是没有赋值，则这个时候线程B进来，发现已经不会为null了，就返回了，所以线程B会出现空指针异常（这是一种情况）；（情况二：）A刚刚进入判断体，线程B也刚刚进来，则会B也进入了判断体，就有两个线程进行实例化的问题。所以这是一个不安全的单例
> 安全的单例写法:
```
public class SafeSingleton {
    /**
     * 加上volatile避免重排序问题
     */
    private static volatile SafeSingleton safeSingleton;

    private SafeSingleton(){

    }

    public static SafeSingleton getInstance(){
        //双重锁判断，避免了线程重进入安全问题
        if(safeSingleton==null){
            synchronized (SafeSingleton.class){
                if(safeSingleton==null){
                    safeSingleton=new SafeSingleton();
                }
            }
        }
        
        return safeSingleton;
    }
}
```
[代码链接](https://github.com/fightcrap/javaStudy/blob/master/design/src/main/java/com/pangxie/server/singleton/SafeSingleton.java)
## 多形式的单例模式
-   [饿汉式](https://github.com/fightcrap/javaStudy/blob/master/design/src/main/java/com/pangxie/server/singleton/HungrySingleton.java)
    ```
    public class HungrySingleton {

        private static HungrySingleton hungrySingleton=new HungrySingleton();

        private HungrySingleton(){

        }

        /**
        * 饿汉模式会优先初始化对象。所以是线程安全的
        * @return
        */
        public static  HungrySingleton getInstance(){
            if(hungrySingleton==null){
                hungrySingleton=new HungrySingleton();
            }

            return hungrySingleton;
        }
    }
    ```
- [懒汉模式](https://github.com/fightcrap/javaStudy/blob/master/design/src/main/java/com/pangxie/server/singleton/UnsafeSingleton.java)
    ```
    public class UnsafeSingleton {

        private static UnsafeSingleton unsafeSingleton;

        /**
        * 私有构造器，限制外部不能实例
        */
        private UnsafeSingleton() {

        }

        public static UnsafeSingleton getInstance() {
            if (unsafeSingleton == null) {
                unsafeSingleton = new UnsafeSingleton();
            }
            return unsafeSingleton;
        }
    }
    ```
- [懒汉模式(线程安全版)](https://github.com/fightcrap/javaStudy/blob/master/design/src/main/java/com/pangxie/server/singleton/SafeLazySingleton.java)
    ```
    public class SafeLazySingleton {
        private static SafeLazySingleton safeLazySingleton;

        private SafeLazySingleton(){

        }

        /**
        * 利用synchronized 锁定类对象，锁的力度更大，使得锁的限制在调用前。确保逻辑走完，所以线程安全
        * @return
        */
        public static synchronized SafeLazySingleton getInstance(){
            if(safeLazySingleton==null){
                safeLazySingleton=new SafeLazySingleton();
            }
            return safeLazySingleton;
        }
    }
    ```
- [懒汉模式（双重锁判断）](https://github.com/fightcrap/javaStudy/blob/master/design/src/main/java/com/pangxie/server/singleton/UnsafeSingleton.java)
    ```
    public class UnsafeSingleton {

        private static UnsafeSingleton unsafeSingleton;

        /**
        * 私有构造器，限制外部不能实例
        */
        private UnsafeSingleton() {

        }

        public static UnsafeSingleton getInstance() {
            if (unsafeSingleton == null) {
             unsafeSingleton = new UnsafeSingleton();
            }
            return unsafeSingleton;
        }
    }
    ```
- [静态内部类单例模式](https://github.com/fightcrap/javaStudy/blob/master/design/src/main/java/com/pangxie/server/singleton/SingletonDesign.java)
    ```
    public class SingletonDesign {


        /**
        * 利用静态内部类加载的形式，限制外部访问，并且初始化本身,达到单例的目的
        */
        private static class Singleton{
            public static final   SingletonDesign singletonDesign=new SingletonDesign();
        }

        private SingletonDesign(){

        }

        public static SingletonDesign getInstance(){
            return Singleton.singletonDesign;
        }
    }
    ```
- [枚举单例](https://github.com/fightcrap/javaStudy/blob/master/design/src/main/java/com/pangxie/server/singleton/Singleton.java)
    ```
    public enum Singleton {
        SINGLETON;
    }
    ```