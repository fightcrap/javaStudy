package com.pangxie.server.nio.thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

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
 * | SelectorClientThread
 * |
 * | @author fightingcrap
 **/
public class SelectorClientThread implements Runnable {

    private String host;

    private Integer ip;

    private Selector selector;

    private SocketChannel socketChannel;

    private volatile boolean stop = false;

    public SelectorClientThread(String host, Integer ip) throws IOException {
        //打开多路复用器
        selector = Selector.open();
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        this.host = host;
        this.ip = ip;
        //链接
        doConnect();

    }

    @Override
    public void run() {
        //循环监听
        while (!stop) {
            try {
                selector.select(1000);

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    //处理状态信息
                    doHandle(selectionKey);
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (selector != null) {
                    try {
                        selector.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

        }

    }

    /**
     * 链接
     *
     * @throws IOException
     */
    private void doConnect() throws IOException {
        boolean result = socketChannel.connect(new InetSocketAddress(host, ip));
        if (result) {
            //链接成功，直接进入待读状态
            socketChannel.register(selector, SelectionKey.OP_READ);
        } else {
            //链接失败，则进入待链接状态，等待重拾
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doHandle(SelectionKey selectionKey) throws IOException {
        //判断key是否可用
        if (!selectionKey.isValid()) {
            return;
        }
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        //判断是否链接成功
        if (selectionKey.isConnectable()) {
            //如果已经完成链接了
            if (socketChannel.finishConnect()) {
                //注册读操作
                socketChannel.register(selector, SelectionKey.OP_READ);
                //发条数据过去
                doWrite("hellow", socketChannel);

            } else {
                //结束
            }
        }
        //是否处于可读状态
        if (selectionKey.isReadable()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int readByte = socketChannel.read(byteBuffer);
            if (readByte > 0) {
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.remaining()];
                byteBuffer.get(bytes);
                String content = new String(bytes, "UTF-8");
                System.out.println("get message :" + content);
                //关闭
                this.stop = true;
            } else if (readByte < 0) {
                //结束了
                selectionKey.cancel();
                socketChannel.close();
            }

        }

    }


    private void doWrite(String message, SocketChannel socketChannel) throws IOException {
        if (null == message || "".equals(message)) {
            return;
        }
        byte[] bytes = message.getBytes();
        //创建缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        //判断是否有留存
        if (!byteBuffer.hasRemaining()) {
            System.out.println("send message over");
        }
    }
}
