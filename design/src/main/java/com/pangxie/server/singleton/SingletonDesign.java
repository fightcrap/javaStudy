package com.pangxie.server.singleton;

/**
 * Create By fightingcrap On 2018/12/17
 * |  .--,       .--,
 * |( (  \.---./  ) )
 * | '.__/o   o\__.'
 * |    {=  ^  =}
 * |     >  -  <
 * |    /       \
 * |   //       \\
 * |  //|   .   |\\
 * |  "'\       /'"_.-~^`'-.
 * |     \  _  /--'         `
 * |   ___)( )(___
 * |  (((__) (__)))    程序镇压神兽，排查一切bug。
 * |
 * |
 * | SingletonDesign   --静态内部类单例模式
 * |
 * | @author fightingcrap
 **/
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
