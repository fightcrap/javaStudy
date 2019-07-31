package com.pangxie.server.bio.server;

import com.pangxie.server.constant.Constants;
import com.pangxie.server.bio.thread.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create By fightingcrap On 2019/07/29
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

    public static void main(String[] args) throws IOException {
        //服务监听是需要端口号的
        ServerSocket serverSocket=new ServerSocket(Constants.PORT);
        //循环监听端口号，
        System.out.println("serverSocket create");
        while (true){
            //没有连接请求会阻塞,有连接请求则创建socket对象
            Socket socket=serverSocket.accept();

            //启动一个线程去处理
            new Thread(new TimeServerHandler(socket)).start();
        }

    }
}
