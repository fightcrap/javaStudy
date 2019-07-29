package com.pangxie.server.bio.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
 * | TimeServerHandler
 * |
 * | @author fightingcrap
 **/
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //读取socket的内容
        //打开socket输入流
        try(BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true)) {

            //循环读取socket中的内容　
            while (true){
                String body=bufferedReader.readLine();
                if(null==body||"".equals(body)){
                    break;
                }
                System.out.println("server read content:"+body);
                //返回当前时间
                printWriter.println("server return time:"+System.currentTimeMillis());

            }

        } catch (IOException e) {
            e.printStackTrace();
            //同时关闭socket
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            //清空回收
            socket=null;
        }
    }
}
