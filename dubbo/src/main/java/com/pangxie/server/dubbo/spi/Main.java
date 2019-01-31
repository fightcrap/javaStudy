package com.pangxie.server.dubbo.spi;

import com.pangxie.server.dubbo.spi.api.SayWord;

import java.util.ServiceLoader;

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
 * | Main
 * |
 * | @author fightingcrap
 **/
public class Main {

    public static void main(String[] args) {
        ServiceLoader<SayWord> sayWords=ServiceLoader.load(SayWord.class);
        for(SayWord sayWord:sayWords){
            System.out.println(sayWord.saySomething());
        }
    }
}
