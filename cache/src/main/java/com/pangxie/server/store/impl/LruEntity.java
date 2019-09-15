package com.pangxie.server.store.impl;

import java.util.Map.Entry;

import com.pangxie.server.store.ValueHolder;

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
 * | LruEntity
 * |
 * | @author fightingcrap
 **/
public class LruEntity<K, V extends ValueHolder<?>> implements Entry<K, ValueHolder<?>> {

    /**
     * non-null
     */

    final K key;

    ValueHolder<?> v;

    LruEntity<K, ValueHolder<?>> pre;
    LruEntity<K, ValueHolder<?>> next;

    public LruEntity(K key, ValueHolder<?> v) {
        this.key = key;
        this.v = v;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public ValueHolder<?> getValue() {
        return v;
    }

    @Override
    public ValueHolder<?> setValue(ValueHolder<?> value) {
        ValueHolder<?> old = this.v;
        this.v = value;
        return old;
    }


    public LruEntity<K, ValueHolder<?>> getPre() {
        return pre;
    }

    public void setPre(LruEntity<K, ValueHolder<?>> pre) {
        this.pre = pre;
    }

    public LruEntity<K, ValueHolder<?>> getNext() {
        return next;
    }

    public void setNext(LruEntity<K, ValueHolder<?>> next) {
        this.next = next;
    }
}
