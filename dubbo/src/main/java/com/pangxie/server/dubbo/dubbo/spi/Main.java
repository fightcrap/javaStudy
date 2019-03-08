package com.pangxie.server.dubbo.dubbo.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.pangxie.server.dubbo.dubbo.spi.api.SayWord;

/**
 * Create By fightingcrap On 2019/02/15
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
        ExtensionLoader<SayWord> loader = ExtensionLoader.getExtensionLoader(SayWord.class);
        SayWord sayWord=loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?say.word=cn");
        System.out.println(sayWord.saySomething("d", url));
    }
}
