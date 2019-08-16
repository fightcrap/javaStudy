package com.pangxie.server.netty.protocol.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

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
 * | NettyHeader
 * |
 * | @author fightingcrap
 **/
@Data
public class NettyHeader {

    /**
     * 校验码
     */
    private int crcCode;

    /**
     * 长度
     */
    private int length;

    /**
     * 会话id
     */
    private long sessionId;

    /**
     * 消息类型
     */
    private byte type;

    /**
     * 消息优先级
     */
    private byte priority;

    /**
     * 扩展消息
     */
    private Map<String, Object> attachment = new HashMap<>();
}
