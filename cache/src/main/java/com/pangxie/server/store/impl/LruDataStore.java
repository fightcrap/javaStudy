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
 * | LruDataStore
 * |
 * | @author fightingcrap
 **/
public class LruDataStore<K, V> implements DataStore<K, V> {

    ConcurrentHashMap<K, LruEntity<K, ValueHolder<?>>> map = new ConcurrentHashMap<>();


    LruEntity<K, ValueHolder<?>> first;

    LruEntity<K, ValueHolder<?>> last;

    private int maxSize = 0;

    public LruDataStore() {
    }

    public LruDataStore(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public ValueHolder<V> get(K key) {
        LruEntity<K, ValueHolder<?>> entry = (LruEntity<K, ValueHolder<?>>) getEntity(key);
        if (entry == null) {
            return null;
        }
        moveToFirst(entry);
        return (ValueHolder<V>) entry.getValue();
    }

    @Override
    public PutStatus put(K key, V value) throws StroeAccessException {

        //先获取是否存在的entity;
        LruEntity<K, ValueHolder<?>> entity = getEntity(key);
        PutStatus status = PutStatus.NOOP;
        if (entity == null) {
            //创建entity
            entity = new LruEntity<>(key, new BaseValueHolder<>(value));
            if (map.size() >= maxSize) {
                //如果上限了，那么就移除
                removeLast();
            }
            status = PutStatus.PUT;
        } else {
            entity.setValue(new BaseValueHolder<>(value));
            status = PutStatus.PUT;
        }
        //移到最前面
        moveToFirst(entity);
        //同时更新缓存
        map.put(key, entity);
        return status;
    }

    @Override
    public ValueHolder<V> remove(K key) throws StroeAccessException {
        //先获取entity
        LruEntity<K, ValueHolder<?>> lruEntity = getEntity(key);

        if (lruEntity == null) {
            return null;
        }

        transform(lruEntity);

        if (lruEntity == first) {
            first = lruEntity.getNext();
        }
        map.remove(key);
        return (ValueHolder<V>) lruEntity.v;
    }

    @Override
    public void clear() throws StroeAccessException {

        this.map.clear();
        this.first = this.last = null;
    }


    private LruEntity<K, ValueHolder<?>> getEntity(K key) {
        return map.get(key);
    }

    private void moveToFirst(LruEntity<K, ValueHolder<?>> lruEntity) {

        if (lruEntity == first) {
            //说明已经是第一个了
            return;
        }

        transform(lruEntity);
        lruEntity.next = first;
        first.pre = lruEntity;
        lruEntity.pre = null;
        first = lruEntity;


    }

    private void transform(LruEntity<K, ValueHolder<?>> lruEntity) {

        if (lruEntity.pre != null) {
            lruEntity.pre.next = lruEntity.next;
        }

        if (lruEntity.next != null) {
            lruEntity.next.pre = lruEntity.pre;
        }

        if (lruEntity == last) {
            last = lruEntity.pre;
        }
    }


    private void removeLast() {
        if (last == null) {
            return;
        }
        last = last.pre;
        if (last == null) {
            //如果前一个已经是null了 那就都是null，不为链　
            first = null;
        } else {
            last.next = null;
        }
    }


}
