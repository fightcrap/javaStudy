package com.pangxie.server.netty.protocol.decoder;

import com.pangxie.server.netty.protocol.channel.ChannelBufferByteInput;
import com.pangxie.server.netty.protocol.channel.ChannelBufferByteOutput;
import com.pangxie.server.netty.protocol.factory.MarshallingCodeCFactory;
import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Unmarshaller;

import java.io.IOException;

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
 * | MarshallingDecoder
 * |
 * | @author fightingcrap
 **/
public class MarshallingDecoder {

    private Unmarshaller unmarshaller;

    public MarshallingDecoder() {
        try {
            this.unmarshaller = MarshallingCodeCFactory.buildMarshallingDecoder();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object decoder(ByteBuf byteBuf) {
        int size = byteBuf.readInt();
        ByteBuf buf = byteBuf.slice(byteBuf.readerIndex(), size);
        ByteInput byteInput = new ChannelBufferByteInput(buf);
        try {
            unmarshaller.start(byteInput);
            Object obj = unmarshaller.readObject();
            unmarshaller.finish();
            byteBuf.readerIndex(byteBuf.readerIndex() + size);
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                unmarshaller.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
