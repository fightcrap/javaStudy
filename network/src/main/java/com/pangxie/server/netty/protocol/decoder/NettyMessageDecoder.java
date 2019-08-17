package com.pangxie.server.netty.protocol.decoder;

import com.pangxie.server.netty.protocol.entity.NettyHeader;
import com.pangxie.server.netty.protocol.entity.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.jboss.marshalling.Marshaller;

import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

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
 * | NettyMessageDecoder
 * |
 * | @author fightingcrap
 **/
public class NettyMessageDecoder extends LengthFieldBasedFrameDecoder {
    private MarshallingDecoder marshallingDecoder;


    public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
        this.marshallingDecoder = new MarshallingDecoder();
    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf byteBuf = (ByteBuf) super.decode(ctx, in);
        if (byteBuf == null) {
            return null;
        }

        NettyMessage nettyMessage = new NettyMessage();
        NettyHeader nettyHeader = new NettyHeader();
        nettyHeader.setCrcCode(byteBuf.readInt());
        nettyHeader.setLength(byteBuf.readInt());
        nettyHeader.setSessionId(byteBuf.readLong());
        nettyHeader.setType(byteBuf.readByte());
        nettyHeader.setPriority(byteBuf.readByte());
        int size = byteBuf.readInt();
        if (size > 0) {
            Map<String, Object> map = new HashMap<>(size);
            for (int i = 0; i < size; i++) {
                int keySize = byteBuf.readInt();
                byte[] keyArray = new byte[keySize];
                byteBuf.readBytes(keyArray);
                String key = new String(keyArray, "UTF-8");
                map.put(key, marshallingDecoder.decoder(byteBuf));
            }
            nettyHeader.setAttachment(map);
        }

        if (byteBuf.readableBytes() > 4) {
            nettyMessage.setBody(marshallingDecoder.decoder(byteBuf));
        }
        nettyMessage.setHeader(nettyHeader);
        return nettyMessage;

    }
}
