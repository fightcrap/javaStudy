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
 * | SafeSingleton  --安全的单例写法
 * |
 * | @author fightingcrap
 **/
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
