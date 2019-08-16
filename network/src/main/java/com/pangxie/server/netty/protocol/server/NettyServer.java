package com.pangxie.server.netty.protocol.server;

import com.pangxie.server.constant.Constants;
import com.pangxie.server.netty.protocol.auth.LoginAuthResHandler;
import com.pangxie.server.netty.protocol.decoder.NettyMessageDecoder;
import com.pangxie.server.netty.protocol.encoder.NettyMessageEncoder;
import com.pangxie.server.netty.protocol.handler.HeartBeatResHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * Create By fightingcrap On 2019/08/16
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
 * | NettyServer
 * |
 * | @author fightingcrap
 **/
public class NettyServer {

    public void bind() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(group, worker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 4, 4))
                                .addLast(new NettyMessageEncoder())
                                .addLast("readTimeout", new ReadTimeoutHandler(50))
                                .addLast("loginAuth", new LoginAuthResHandler())
                                .addLast("heartBeatResHandler", new HeartBeatResHandler());
                    }
                });
        serverBootstrap.bind(Constants.ADDRESS, Constants.PORT).sync();
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyServer().bind();
    }
}
