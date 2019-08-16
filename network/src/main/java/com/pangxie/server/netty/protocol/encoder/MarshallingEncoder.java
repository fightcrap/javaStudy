package com.pangxie.server.netty.protocol.encoder;

import com.pangxie.server.netty.protocol.channel.ChannelBufferByteOutput;
import com.pangxie.server.netty.protocol.factory.MarshallingCodeCFactory;
import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;

import java.io.IOException;

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
 * | MarshallingEncoder
 * |
 * | @author fightingcrap
 **/
public class MarshallingEncoder {

    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    private Marshaller marshaller;

    public MarshallingEncoder() throws IOException {
        marshaller = MarshallingCodeCFactory.buildMarshallingEncoder();
    }

    public void encode(Object msg, ByteBuf byteBuf) throws IOException {
        try {
            int lengthpos = byteBuf.writerIndex();
            byteBuf.writeBytes(LENGTH_PLACEHOLDER);
            ChannelBufferByteOutput channelBufferByteOutput = new ChannelBufferByteOutput(byteBuf);
            marshaller.start(channelBufferByteOutput);
            marshaller.writeObject(msg);
            marshaller.finish();
            byteBuf.setInt(lengthpos, byteBuf.writerIndex() - lengthpos - 4);
        } finally {
            marshaller.close();
        }


    }
}
