package com.pangxie.server.store.impl;

import com.pangxie.server.store.ValueHolder;

import java.lang.ref.WeakReference;

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
 * | WeakValueHolder
 * |
 * | @author fightingcrap
 **/
public class WeakValueHolder<V> implements ValueHolder<V> {

    private WeakReference<V> weakReference;

    public WeakValueHolder(V value) {
        this.weakReference = new WeakReference<>(value);
    }


    @Override
    public V value() {
        return weakReference.get();
    }
}
