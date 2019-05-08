package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.romantointeger.RomanToIntegerV1;
import com.pangxie.server.leetcode.easy.romantointeger.RomanToIntegerV2;
import com.pangxie.server.leetcode.easy.romantointeger.RomanToIntegerV3;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create By fightingcrap On 2019/05/08
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
 * | RomanToIntegerTest
 * |
 * | @author fightingcrap
 **/
public class RomanToIntegerTest {

    @Test
    public void test() {
        RomanToIntegerV1 romanToIntegerV1 = new RomanToIntegerV1();

        Assert.assertTrue(romanToIntegerV1.romanToInt("III") == 3);

        Assert.assertTrue(romanToIntegerV1.romanToInt("IV") == 4);

        Assert.assertTrue(romanToIntegerV1.romanToInt("IX") == 9);

        Assert.assertTrue(romanToIntegerV1.romanToInt("LVIII") == 58);

        Assert.assertTrue(romanToIntegerV1.romanToInt("MCMXCIV") == 1994);

        RomanToIntegerV2 romanToIntegerV2 = new RomanToIntegerV2();

        Assert.assertTrue(romanToIntegerV2.romanToInt("III") == 3);

        Assert.assertTrue(romanToIntegerV2.romanToInt("IV") == 4);

        Assert.assertTrue(romanToIntegerV2.romanToInt("IX") == 9);

        Assert.assertTrue(romanToIntegerV2.romanToInt("LVIII") == 58);

        Assert.assertTrue(romanToIntegerV2.romanToInt("MCMXCIV") == 1994);

        RomanToIntegerV3 romanToIntegerV3 = new RomanToIntegerV3();

        Assert.assertTrue(romanToIntegerV3.romanToInt("III") == 3);

        Assert.assertTrue(romanToIntegerV3.romanToInt("IV") == 4);

        Assert.assertTrue(romanToIntegerV3.romanToInt("IX") == 9);

        Assert.assertTrue(romanToIntegerV3.romanToInt("LVIII") == 58);

        Assert.assertTrue(romanToIntegerV3.romanToInt("MCMXCIV") == 1994);
    }
}
