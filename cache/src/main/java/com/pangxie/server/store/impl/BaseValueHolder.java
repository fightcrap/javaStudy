package com.pangxie.server.store.impl;

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
 * | BaseValueHolder
 * |
 * | @author fightingcrap
 **/
public class BaseValueHolder<V> implements ValueHolder<V> {

    private V v;

    public BaseValueHolder(V v) {
        this.v = v;
    }

    @Override
    public V value() {
        return v;
    }
}
