package com.pangxie.server.dubbo.dubbo.spi.impl;

import com.alibaba.dubbo.common.URL;
import com.pangxie.server.dubbo.dubbo.spi.api.SayWord;

/**
 * Create By fightingcrap On 2019/01/30
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
 * | SayChineseWord
 * |
 * | @author fightingcrap
 **/
public class SayChineseWord implements SayWord {
    @Override
    public String saySomething(String message, URL url) {
        return "你好啊";
    }
}
