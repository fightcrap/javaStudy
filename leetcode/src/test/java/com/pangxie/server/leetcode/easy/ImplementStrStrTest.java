package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.implementstrstr.ImplementStrStrV1;
import com.pangxie.server.leetcode.easy.implementstrstr.ImplementStrStrV2;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create By fightingcrap On 2019/05/14
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
 * | ImplementStrStrTest
 * |
 * | @author fightingcrap
 **/
public class ImplementStrStrTest {

    @Test
    public void test() {
        ImplementStrStrV1 implementStrStrV1 = new ImplementStrStrV1();
        Assert.assertEquals(implementStrStrV1.strStr("hello",  "ll"),2);
        Assert.assertEquals(implementStrStrV1.strStr("aaaaa",  "bba"),-1);

        ImplementStrStrV2 implementStrStrV2 = new ImplementStrStrV2();
        Assert.assertEquals(implementStrStrV2.strStr("hello",  "ll"),2);
        Assert.assertEquals(implementStrStrV2.strStr("aaaaa",  "bba"),-1);
    }
}
