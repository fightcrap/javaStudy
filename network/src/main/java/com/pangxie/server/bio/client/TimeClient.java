package com.pangxie.server.bio.client;

import com.pangxie.server.bio.constant.Constants;

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
 * | TimeClient
 * |
 * | @author fightingcrap
 **/
public class TimeClient {

    public static void main(String[] args) throws IOException {
        //指定连接端口
        //指定地址
        Socket socket=new Socket(Constants.ADDRESS,Constants.PORT);
        //连接成功后，同样是输入输出

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
        System.out.println("client send message");
        printWriter.println("send a message");
        //读取一条信息
        String body=bufferedReader.readLine();
        System.out.println("client get message:"+body);
        //关闭sock
        socket.close();
    }
}
