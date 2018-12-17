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
 * | HungrySingleton  --饿汉式单例模式
 * |
 * | @author fightingcrap
 **/
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
