package com.pangxie.server.store;

/**
 * Create By fightingcrap On 2019/09/14
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
 * | DataStore
 * |
 * | @author fightingcrap
 **/
public interface DataStore<K, V> {

    ValueHolder<V> get(K key);

    PutStatus put(K key, V value) throws StroeAccessException;

    ValueHolder<V> remove(K key) throws StroeAccessException;

    void clear() throws StroeAccessException;

    enum PutStatus {
        /**
         * New value was put
         */
        PUT,
        /**
         * New value was put and replace old value
         */
        UPDATE,
        /**
         * New value was dropped
         */
        NOOP
    }
}
