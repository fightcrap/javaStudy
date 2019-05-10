package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.validparentheses.ValidParenthesesV1;
import com.pangxie.server.leetcode.easy.validparentheses.ValidParenthesesV2;
import com.pangxie.server.leetcode.easy.validparentheses.ValidParenthesesV3;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create By fightingcrap On 2019/05/10
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
 * | ValidParenthesesTest
 * |
 * | @author fightingcrap
 **/
public class ValidParenthesesTest {


    @Test
    public void test(){

        ValidParenthesesV1 validParenthesesV1 =new ValidParenthesesV1();

        Assert.assertTrue(validParenthesesV1.isValid("()"));

        Assert.assertTrue(validParenthesesV1.isValid("()[]{}"));

        Assert.assertTrue(!validParenthesesV1.isValid("(]"));

        Assert.assertTrue(!validParenthesesV1.isValid("([)]"));

        Assert.assertTrue(validParenthesesV1.isValid("{[]}"));

        ValidParenthesesV2 validParenthesesV2 =new ValidParenthesesV2();

        Assert.assertTrue(validParenthesesV2.isValid("()"));

        Assert.assertTrue(validParenthesesV2.isValid("()[]{}"));

        Assert.assertTrue(!validParenthesesV2.isValid("(]"));

        Assert.assertTrue(!validParenthesesV2.isValid("([)]"));

        Assert.assertTrue(validParenthesesV2.isValid("{[]}"));

        ValidParenthesesV3 validParenthesesV3 =new ValidParenthesesV3();

        Assert.assertTrue(validParenthesesV3.isValid("()"));

        Assert.assertTrue(validParenthesesV3.isValid("()[]{}"));

        Assert.assertTrue(!validParenthesesV3.isValid("(]"));

        Assert.assertTrue(!validParenthesesV3.isValid("([)]"));

        Assert.assertTrue(validParenthesesV3.isValid("{[]}"));

    }
}
