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
 * | LazySingleton --懒汉模式单例（线程安全）
 * |
 * | @author fightingcrap
 **/
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
