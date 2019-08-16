package com.pangxie.server.netty.protocol.factory;


import org.jboss.marshalling.*;

import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;

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
 * | MarshallingCodecFactory
 * |
 * | @author fightingcrap
 **/


public class MarshallingCodeCFactory {

    /**
     * 创建Jboss Marshalling解码器MarshallingDecoder
     *
     * @return
     */
    public static Unmarshaller buildMarshallingDecoder() throws IOException {
        //首先通过Marshalling工具类的方法获取Marshalling实例对象 参数serial标识创建的是java序列化工厂对象
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        //创建MarshallingConfiguration对象，配置版本号为5
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        //根据MarshallerFactory和configuration创建provide
        Unmarshaller unmarshaller = marshallerFactory.createUnmarshaller(configuration);
        //构建netty的marshallingDecoder，两个参数分别为provider和单个消息序列化后的最大长度
        return unmarshaller;
    }

    /**
     * 创建Jboss Marshalling编码器MarshallingEncoder
     *
     * @return
     */
    public static Marshaller buildMarshallingEncoder() throws IOException {
        //首先通过Marshalling工具类的方法获取Marshalling实例对象 参数serial标识创建的是java序列化工厂对象
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        //创建MarshallingConfiguration对象，配置版本号为5
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        //根据MarshallerFactory和configuration创建provide

        return marshallerFactory.createMarshaller(configuration);

    }

}
