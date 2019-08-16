package com.pangxie.server.netty.protocol.channel;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;

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
 * | ChannelBufferByteInput
 * |
 * | @author fightingcrap
 **/
public class ChannelBufferByteInput implements ByteInput {

    private final ByteBuf buffer;

    public ChannelBufferByteInput(ByteBuf buffer) {
        this.buffer = buffer;
    }

    @Override
    public int read() throws IOException {
        if (buffer.isReadable()) {
            return buffer.readByte() & 0xff;
        }
        return -1;
    }

    @Override
    public int read(byte[] bytes) throws IOException {
        return read(bytes, 0, bytes.length);
    }

    @Override
    public int read(byte[] bytes, int i, int i1) throws IOException {
        int available = available();
        if (available == 0) {
            return -1;
        }
        i1 = Math.min(available, i1);
        buffer.readBytes(bytes, i, i1);
        return i1;
    }

    @Override
    public int available() throws IOException {
        return buffer.readableBytes();
    }

    @Override
    public long skip(long l) throws IOException {
        int readable = buffer.readableBytes();
        if (readable < l) {
            l = readable;
        }
        buffer.readerIndex((int) (buffer.readerIndex() + l));
        return l;
    }

    @Override
    public void close() throws IOException {

    }
}
