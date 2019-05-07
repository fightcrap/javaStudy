package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.reverseinteger.ReverseIntegerV1;
import com.pangxie.server.leetcode.easy.reverseinteger.ReverseIntegerV2;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create By fightingcrap On 2019/05/06
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
 * | ReverseIntegerTest
 * |
 * | @author fightingcrap
 **/
public class ReverseIntegerTest {
    @Test
    public void test() {

        ReverseIntegerV1 reverseIntegerV1 = new ReverseIntegerV1();
        int result = reverseIntegerV1.reverse(123);
        Assert.assertTrue(result == 321);
        result = reverseIntegerV1.reverse(-123);
        Assert.assertTrue(result == -321);
        result = reverseIntegerV1.reverse(120);
        Assert.assertTrue(result == 21);
        ReverseIntegerV2 reverseIntegerV2 = new ReverseIntegerV2();
        result = reverseIntegerV2.reverse(123);
        Assert.assertTrue(result == 321);
        result = reverseIntegerV2.reverse(-123);
        Assert.assertTrue(result == -321);
        result = reverseIntegerV2.reverse(120);
        Assert.assertTrue(result == 21);
    }
}
