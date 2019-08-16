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


    public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }

    public NettyMessageDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }

    public NettyMessageDecoder(ByteOrder byteOrder, int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf byteBuf = (ByteBuf) super.decode(ctx, in);
        if (byteBuf == null) {
            return null;
        }

        NettyMessage nettyMessage = new NettyMessage();
        NettyHeader nettyHeader = new NettyHeader();
        nettyHeader.setCrcCode(in.readInt());
        nettyHeader.setLength(in.readInt());
        nettyHeader.setSessionId(in.readLong());
        nettyHeader.setType(in.readByte());
        nettyHeader.setPriority(in.readByte());
        int size = in.readInt();
        if (size > 0) {
            Map<String, Object> map = new HashMap<>(size);
            for (int i = 0; i < size; i++) {
                int keySize = in.readInt();
                byte[] keyArray = new byte[keySize];
                in.readBytes(keyArray);
                String key = new String(keyArray, "UTF-8");
                map.put(key, marshallingDecoder.decoder(in));
            }
            nettyHeader.setAttachment(map);
        }

        if (in.readableBytes() > 4) {
            nettyMessage.setBody(marshallingDecoder.decoder(in));
        }
        nettyMessage.setHeader(nettyHeader);
        return nettyMessage;

    }
}
