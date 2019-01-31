package com.pangxie.server.dubbo.spi;

import com.pangxie.server.dubbo.spi.api.SayWord;
import com.pangxie.server.dubbo.spi.loader.NewServiceLoader;

import java.util.LinkedHashMap;

/**
 * Create By fightingcrap On 2019/01/31
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
 * | NewServiceLoaderMain
 * |
 * | @author fightingcrap
 **/
public class NewServiceLoaderMain {
    public static void main(String[] args) {
        NewServiceLoader<SayWord> sayWords=NewServiceLoader.load(SayWord.class);
        LinkedHashMap<String,SayWord> linkedHashMap=sayWords.getProviders();
        for(SayWord sayWord:linkedHashMap.values()){
            System.out.println(sayWord.saySomething());
        }
    }
}
