package com.pangxie.server.netty.example.server;

import com.pangxie.server.constant.Constants;
import com.pangxie.server.netty.example.server.handler.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * Create By fightingcrap On 2019/08/03
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
        try {
            new TimeServer().bind(Constants.PORT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public void bind(Integer port) throws InterruptedException {

        //构建服务端的NIO线程组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        //工作线程组
        EventLoopGroup executorWorks = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(eventExecutors, executorWorks)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChildChannelHandler());
        try {
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();

            channelFuture.channel().closeFuture().sync();
        } finally {
            eventExecutors.shutdownGracefully();
            executorWorks.shutdownGracefully();
        }


    }


    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }
}
