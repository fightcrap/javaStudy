package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.countandsay.CountAndSayV1;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create By fightingcrap On 2019/05/16
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
 * | CountAndSayV1
 * |
 * | @author fightingcrap
 **/
public class CountAndSayTest {

    @Test
    public void test(){
        CountAndSayV1 countAndSayV1=new CountAndSayV1();
        Assert.assertEquals("1",countAndSayV1.countAndSay(1));
        Assert.assertEquals("11",countAndSayV1.countAndSay(2));
        Assert.assertEquals("21",countAndSayV1.countAndSay(3));
        Assert.assertEquals("1211",countAndSayV1.countAndSay(4));
        Assert.assertEquals("111221",countAndSayV1.countAndSay(5));
    }
}
