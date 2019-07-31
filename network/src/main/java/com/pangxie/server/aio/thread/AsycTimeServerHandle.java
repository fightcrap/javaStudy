package com.pangxie.server.aio.thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.CountDownLatch;

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
 * | AsycTimeServerHandle
 * |
 * | @author fightingcrap
 **/
public class AsycTimeServerHandle implements Runnable {

    private Integer port;

    protected CountDownLatch countDownLatch;

    protected AsynchronousServerSocketChannel asynchronousServerSocketChannel;


    public AsycTimeServerHandle(Integer port) throws IOException {
        this.port = port;
        //打开异步socketChannel
        asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
        //监听地址
        asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
        System.out.println("server start");
    }

    @Override
    public void run() {

        //设置栏杆为1，等待一个唤醒　
        countDownLatch = new CountDownLatch(1);
        //监听链接
        asynchronousServerSocketChannel.accept(this,new AcceptComletionHandler());
        try {
            //防止线程结束。。。
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
