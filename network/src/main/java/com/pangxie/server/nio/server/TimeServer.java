package com.pangxie.server.nio.server;

import com.pangxie.server.nio.thread.SelectorServerThread;

/**
 * Create By fightingcrap On 2019/07/30
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
 * | TimeServer
 * |
 * | @author fightingcrap
 **/
public class TimeServer {

    public static void main(String[] args) {

        SelectorServerThread selectorServerThread = new SelectorServerThread();
        new Thread(selectorServerThread).start();
    }
}
