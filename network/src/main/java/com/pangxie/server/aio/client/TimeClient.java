package com.pangxie.server.aio.client;

import com.pangxie.server.aio.thread.AsyncTimeClientHandler;
import com.pangxie.server.constant.Constants;

import java.io.IOException;

/**
 * Create By fightingcrap On 2019/07/31
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
 * | TimeClient
 * |
 * | @author fightingcrap
 **/
public class TimeClient {

    public static void main(String[] args) throws IOException {
        new Thread(new AsyncTimeClientHandler(Constants.ADDRESS,Constants.PORT)).start();
    }
}
