package com.pangxie.server.netty.protocol.handler;

import com.pangxie.server.netty.protocol.entity.NettyHeader;
import com.pangxie.server.netty.protocol.entity.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

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
 * | HeartBeatResHandler
 * |
 * | @author fightingcrap
 **/
public class HeartBeatResHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage nettyMessage = (NettyMessage) msg;

        if (nettyMessage != null && nettyMessage.getHeader().getType() == (byte) 5) {
            System.out.println("server get heart");
            NettyMessage nettyMessage1 = buildHeart();
            ctx.writeAndFlush(nettyMessage1);
        } else {
            ctx.fireChannelRead(msg);
        }

    }

    private NettyMessage buildHeart() {
        NettyMessage nettyMessage = new NettyMessage();
        NettyHeader nettyHeader = new NettyHeader();
        nettyHeader.setType((byte) 6);
        nettyMessage.setHeader(nettyHeader);
        return nettyMessage;
    }
}
