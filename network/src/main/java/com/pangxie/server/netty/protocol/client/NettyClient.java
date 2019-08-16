package com.pangxie.server.netty.protocol.client;

import com.pangxie.server.constant.Constants;
import com.pangxie.server.netty.protocol.auth.LoginAuthReqHandler;
import com.pangxie.server.netty.protocol.decoder.NettyMessageDecoder;
import com.pangxie.server.netty.protocol.encoder.NettyMessageEncoder;
import com.pangxie.server.netty.protocol.handler.HeartBeatReqHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import javassist.bytecode.analysis.Executor;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
 * | NettyClient
 * |
 * | @author fightingcrap
 **/
public class NettyClient {

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    EventLoopGroup group = new NioEventLoopGroup();

    public void connect(int port, String host) throws InterruptedException {
        try {

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024, 4, 4))
                                    .addLast("nettyMessage Encoder", new NettyMessageEncoder())
                                    .addLast("readTimeOutHandler", new ReadTimeoutHandler(50))
                                    .addLast("loginAuth", new LoginAuthReqHandler())
                                    .addLast("heart", new HeartBeatReqHandler());
                        }


                    });
            ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress(host, port), new InetSocketAddress(host, 3322)).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                        connect(Constants.PORT,Constants.ADDRESS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new NettyClient().connect(Constants.PORT,Constants.ADDRESS);
    }
}
