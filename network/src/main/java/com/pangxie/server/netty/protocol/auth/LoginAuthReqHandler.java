package com.pangxie.server.netty.protocol.auth;

import com.pangxie.server.netty.protocol.entity.NettyHeader;
import com.pangxie.server.netty.protocol.entity.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Create By fightingcrap On 2019/08/15
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
 * | LoginAuthReqHandler
 * |
 * | @author fightingcrap
 **/
public class LoginAuthReqHandler extends ChannelHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(buildLoginReq());
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage nettyMessage = (NettyMessage) msg;
        if (nettyMessage.getHeader() != null && nettyMessage.getHeader().getType() == (byte) 3) {
            byte loginResult = (byte) nettyMessage.getBody();
            if (loginResult != (byte) 0) {
                System.out.println("链接关闭");
                ctx.close();
            } else {
                ctx.fireChannelRead(msg);
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }

    private NettyMessage buildLoginReq() {
        NettyMessage nettyMessage = new NettyMessage();
        NettyHeader nettyHeader = new NettyHeader();
        nettyHeader.setType((byte) 3);
        nettyMessage.setHeader(nettyHeader);
        return nettyMessage;
    }
}
