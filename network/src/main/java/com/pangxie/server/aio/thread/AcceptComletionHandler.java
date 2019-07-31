package com.pangxie.server.aio.thread;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Create By fightingcrap On 2019/07/31
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
 * | AcceptComletionHandler
 * |
 * | @author fightingcrap
 **/
public class AcceptComletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsycTimeServerHandle> {

    @Override
    public void completed(AsynchronousSocketChannel result, AsycTimeServerHandle attachment) {
        attachment.asynchronousServerSocketChannel.accept(attachment, this);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        result.read(byteBuffer, byteBuffer, new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsycTimeServerHandle attachment) {
        exc.printStackTrace();
        attachment.countDownLatch.countDown();
    }
}
