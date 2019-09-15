package com.pangxie.server.store;

/**
 * Create By fightingcrap On 2019/09/15
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
 * | PxCache
 * |
 * | @author fightingcrap
 **/
public class PxCache<K,V> {

    private final DataStore<K, V> store;


    public PxCache(DataStore<K, V> store) {
        this.store = store;
    }

    public V get(final K key) {
        try {
            ValueHolder<V> value = store.get(key);
            if (null == value) {
                return null;
            }
            return value.value();
        } catch (StroeAccessException e) {
           e.printStackTrace();
            return null;
        }
    }

    public void put(final K key, final V value) {
        try {
            store.put(key, value);
        } catch (StroeAccessException e) {
           e.printStackTrace();
        }
    }

    public V remove(K key) {
        try {
            ValueHolder<V> value = store.remove(key);
            return value.value();
        } catch (StroeAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
        try {
            store.clear();
        } catch (StroeAccessException e) {
           e.printStackTrace();
        }
    }
}
