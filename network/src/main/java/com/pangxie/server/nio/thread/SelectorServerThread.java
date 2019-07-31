package com.pangxie.server.nio.thread;

import com.pangxie.server.constant.Constants;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Create By fightingcrap On 2019/07/30
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
 * | SelectorServerThread
 * |
 * | @author fightingcrap
 **/
public class SelectorServerThread implements Runnable {

    /**
     * selector多路复用器
     */
    private Selector selector;


    /**
     * socketchannel,监听客户端连接
     */
    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop = false;

    public SelectorServerThread(int port) {
        try {
            //打开多路复用器
            selector = Selector.open();
            //打开监听器
            serverSocketChannel = ServerSocketChannel.open();

            //设置非阻塞
            serverSocketChannel.configureBlocking(false);
            //监听端口，和最大连接数
            serverSocketChannel.bind(new InetSocketAddress(Constants.PORT), 1024);
            //多路复用器注册到监听器上面
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server is start");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        //循环便利
        while (!stop) {
            //设置唤醒间断时间
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();

                Iterator<SelectionKey> iterable = selectionKeySet.iterator();
                SelectionKey selectionKey = null;
                while (iterable.hasNext()) {
                    selectionKey = iterable.next();
                    //移除当前key
                    iterable.remove();
                    //处理key内容
                    handleSelectorKey(selectionKey);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void handleSelectorKey(SelectionKey selectionKey) throws IOException {
        //判断是否就绪
        if (!selectionKey.isValid()) {
            return;
        }
        //如果已经准备接入新的socket
        if (selectionKey.isAcceptable()) {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            //获取socketchannel,建立连接,设置非阻塞
            socketChannel.configureBlocking(false);
            //新的连接注册到selector上面,并读取数据
            socketChannel.register(selector, SelectionKey.OP_READ);

        }
        //已经准备好读取了
        if (selectionKey.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            //构建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int readByte = socketChannel.read(byteBuffer);
            //如果读取到了
            if (readByte > 0) {
                //标记读取
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.remaining()];
                //写入字节
                byteBuffer.get(bytes);
                String content = new String(bytes, "utf-8");
                System.out.println("the time :" + System.currentTimeMillis() + " get message:" + content);
                //并写会数据
                doWrite(socketChannel,System.currentTimeMillis()+"");
            } else if (readByte < 0) {
                //如果读取完了关闭
                selectionKey.cancel();
                //关闭socket连接
                socketChannel.close();
            }

        }
    }

    private void doWrite(SocketChannel socketChannel, String response) throws IOException {
        if (null == response || response.length() <= 0) {
            return;
        }
        byte[] bytes = response.getBytes();
        //写入也是要用缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }
}
