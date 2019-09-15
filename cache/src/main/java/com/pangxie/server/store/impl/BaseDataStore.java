package com.pangxie.server.store.impl;

import com.pangxie.server.store.DataStore;
import com.pangxie.server.store.StroeAccessException;
import com.pangxie.server.store.ValueHolder;

import java.util.concurrent.ConcurrentHashMap;

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
 * | BaseDataStore
 * |
 * | @author fightingcrap
 **/
public class BaseDataStore<K, V> implements DataStore<K, V> {

    ConcurrentHashMap<K, ValueHolder<V>> concurrentHashMap = new ConcurrentHashMap<>();

    @Override
    public ValueHolder<V> get(K key) {
        return concurrentHashMap.get(key);
    }

    @Override
    public PutStatus put(K key, V value) throws StroeAccessException {
        BaseValueHolder<V> vBaseValueHolder = new BaseValueHolder<>(value);
        concurrentHashMap.put(key, vBaseValueHolder);
        return PutStatus.PUT;
    }

    @Override
    public ValueHolder<V> remove(K key) throws StroeAccessException {
        return concurrentHashMap.remove(key);
    }

    @Override
    public void clear() throws StroeAccessException {
        concurrentHashMap.clear();
    }
}
