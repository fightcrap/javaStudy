package com.pangxie.server.netty.protocol.handler;

import com.pangxie.server.netty.protocol.entity.NettyHeader;
import com.pangxie.server.netty.protocol.entity.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.ScheduledFuture;
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
 * | HeartBeatReqHandler
 * |
 * | @author fightingcrap
 **/
public class HeartBeatReqHandler extends ChannelHandlerAdapter {

    private volatile ScheduledFuture<?> heartBeat;


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        NettyMessage nettyMessage = (NettyMessage) msg;

        if (nettyMessage != null && nettyMessage.getHeader().getType() == 4) {
            heartBeat = ctx.executor().scheduleAtFixedRate(new HeartBeatReqHandler.HeartBeatTask(ctx), 0, 5000, TimeUnit.MILLISECONDS);
        } else if (nettyMessage != null && nettyMessage.getHeader().getType() == 6) {
            System.out.println("get hearter");
        } else {
            ctx.fireChannelRead(msg);
        }
    }


    private class HeartBeatTask implements Runnable {

        private final ChannelHandlerContext channelHandlerContext;

        public HeartBeatTask(ChannelHandlerContext channelHandlerContext) {
            this.channelHandlerContext = channelHandlerContext;
        }

        @Override
        public void run() {

            NettyMessage nettyMessage = buildHeart();
            System.out.println("client send heart");
            channelHandlerContext.writeAndFlush(nettyMessage);

        }

        private NettyMessage buildHeart() {
            NettyMessage nettyMessage = new NettyMessage();
            NettyHeader nettyHeader = new NettyHeader();
            nettyHeader.setType((byte) 5);
            nettyMessage.setHeader(nettyHeader);
            return nettyMessage;
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (heartBeat != null) {
            heartBeat.cancel(true);
            heartBeat = null;
        }
        ctx.fireExceptionCaught(cause);
    }
}
