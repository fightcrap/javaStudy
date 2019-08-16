package com.pangxie.server.netty.protocol.entity;

import lombok.Data;

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
 * | NettyMessage
 * |
 * | @author fightingcrap
 **/
@Data
public class NettyMessage {

    private NettyHeader header;

    private Object body;
}
