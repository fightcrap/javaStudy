package com.pangxie.server.netty.protocol.auth;

import com.pangxie.server.netty.protocol.entity.NettyHeader;
import com.pangxie.server.netty.protocol.entity.NettyMessage;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
 * | LoginAuthResHandler
 * |
 * | @author fightingcrap
 **/
public class LoginAuthResHandler extends ChannelHandlerAdapter {

    private Map<String, Boolean> nodeCheck = new ConcurrentHashMap<>();

    private String[] writeList = new String[]{"127.0.0.1"};


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到请求");
        NettyMessage nettyMessage = (NettyMessage) msg;
        NettyMessage respon = null;
        if (nettyMessage != null && nettyMessage.getHeader().getType() == (byte) 3) {
            String nodeInde = ctx.channel().remoteAddress().toString();
            if (nodeCheck.get(nodeInde) != null && nodeCheck.get(nodeInde)) {
                respon = buildResponse((byte) -1);
                System.out.println("重复登陆");
            } else {
                InetSocketAddress interfaceAddress = (InetSocketAddress) ctx.channel().remoteAddress();
                String ip = interfaceAddress.getAddress().getHostAddress();
                boolean isOk = false;
                for (String value : writeList) {
                    if (value.equals(ip)) {
                        isOk = true;
                        break;
                    }
                }
                System.out.println("鉴权过了");
                respon = isOk ? buildResponse((byte) 0) : buildResponse((byte) -1);
                nodeCheck.put(nodeInde, isOk);
            }
            ctx.writeAndFlush(respon);
        } else {
            ctx.fireChannelRead(msg);
        }

    }


    private NettyMessage buildResponse(byte a) {
        NettyMessage nettyMessage = new NettyMessage();
        NettyHeader nettyHeader = new NettyHeader();
        nettyHeader.setType((byte) 4);
        nettyMessage.setHeader(nettyHeader);
        nettyMessage.setBody(a);
        return nettyMessage;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        nodeCheck.remove(ctx.channel().remoteAddress().toString());
        ctx.close();
        ctx.fireExceptionCaught(cause);
    }
}
