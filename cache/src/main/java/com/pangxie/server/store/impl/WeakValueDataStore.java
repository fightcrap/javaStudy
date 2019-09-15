package com.pangxie.server.store.impl;

import com.pangxie.server.store.DataStore;
import com.pangxie.server.store.StroeAccessException;
import com.pangxie.server.store.ValueHolder;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

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
 * | WeakValueDataStore
 * |
 * | @author fightingcrap
 **/
public class WeakValueDataStore<K, V> implements DataStore<K, V> {

    private ConcurrentHashMap<K, ValueHolder<V>> map = new ConcurrentHashMap<>();

    @Override
    public ValueHolder<V> get(K key) {
        return map.get(key);
    }

    @Override
    public PutStatus put(K key, V value) throws StroeAccessException {
        WeakValueHolder<V> weakReference = new WeakValueHolder<>(value);
        map.put(key, weakReference);
        return PutStatus.PUT;
    }

    @Override
    public ValueHolder<V> remove(K key) throws StroeAccessException {
        return map.remove(key);
    }

    @Override
    public void clear() throws StroeAccessException {

        map.clear();
    }
}
