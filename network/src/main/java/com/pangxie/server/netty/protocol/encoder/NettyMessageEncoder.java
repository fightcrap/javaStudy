package com.pangxie.server.netty.protocol.encoder;

import com.pangxie.server.netty.protocol.entity.NettyHeader;
import com.pangxie.server.netty.protocol.entity.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.io.IOException;
import java.util.List;

/**
 * Create By fightingcrap On 2019/08/14
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
 * | NettyMessageEncoder
 * |
 * | @author fightingcrap
 **/
public class NettyMessageEncoder extends MessageToByteEncoder<NettyMessage> {

    MarshallingEncoder marshallingEncoder;

    public NettyMessageEncoder() {
        try {
            this.marshallingEncoder = new MarshallingEncoder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, ByteBuf out) throws Exception {

        if (msg == null || msg.getHeader() == null) {
            throw new Exception("msg is null");
        }
        NettyHeader nettyHeader = msg.getHeader();
        out.writeInt(nettyHeader.getCrcCode());
        out.writeInt(nettyHeader.getLength());
        out.writeLong(nettyHeader.getSessionId());
        out.writeByte(nettyHeader.getType());
        out.writeByte(nettyHeader.getPriority());
        out.writeInt(nettyHeader.getAttachment().size());


        for (String key : nettyHeader.getAttachment().keySet()) {
            byte[] keyArray = key.getBytes("UTF-8");

            Object value = nettyHeader.getAttachment().get(key);
            out.writeInt(keyArray.length);
            out.writeBytes(keyArray);
            marshallingEncoder.encode(value, out);

        }

        if (msg.getBody() != null) {
            marshallingEncoder.encode(msg.getBody(), out);
        } else {
            out.writeInt(0);
        }

        out.setInt(4, out.readableBytes()-8);

    }
}
