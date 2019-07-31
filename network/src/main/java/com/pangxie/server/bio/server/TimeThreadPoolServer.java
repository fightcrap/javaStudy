package com.pangxie.server.bio.server;

import com.pangxie.server.bio.thread.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import com.pangxie.server.constant.Constants;

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
 * | TimeThreadPoolServer
 * |
 * | @author fightingcrap
 **/
public class TimeThreadPoolServer {

    private static ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10,20,60L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10,false));

    public static void main(String[] args) throws IOException {

        //监听端口
        ServerSocket serverSocket = new ServerSocket(Constants.PORT);
        while (true) {
            // 循环获取
            Socket socket = serverSocket.accept();

            //构建一个任务
            TimeServerHandler timeServerHandler=new TimeServerHandler(socket);
            threadPoolExecutor.submit(timeServerHandler);
        }
    }
}
