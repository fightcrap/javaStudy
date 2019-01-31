package com.pangxie.server.dubbo.spi.impl;

import com.pangxie.server.dubbo.spi.api.SayWord;

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
 * | SayEnglishWord
 * |
 * | @author fightingcrap
 **/
public class SayEnglishWord implements SayWord {
    @Override
    public String saySomething() {
        return "Hello";
    }
}
