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
 * | UnsafeSingleton ---不安全的单例
 * |
 * | @author fightingcrap
 **/
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
