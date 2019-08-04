package com.pangxie.server.netty.messagepackuse;

import com.alibaba.fastjson.JSONObject;
import org.msgpack.MessagePack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create By fightingcrap On 2019/08/04
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
 * | MessagePackUesDemo
 * |
 * | @author fightingcrap
 **/
public class MessagePackUesDemo {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        MessagePack messagePack = new MessagePack();
        byte[] bytes = messagePack.write(list);

        List<String> list1 = (List<String>) messagePack.read(bytes);
        System.out.println(JSONObject.toJSONString(list1));
    }
}
