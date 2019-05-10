package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.longestcommonprefix.LongestCommonPrefixV1;
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
 * | LongestCommonPrefixTest
 * |
 * | @author fightingcrap
 **/
public class LongestCommonPrefixTest {

    @Test
    public void test() {
        String[] test1 = new String[]{"flower", "flow", "flight"};
        String[] test2 = new String[]{"dog","racecar","car"};
        LongestCommonPrefixV1 longestCommonPrefixV1 = new LongestCommonPrefixV1();
        Assert.assertEquals("fl", longestCommonPrefixV1.longestCommonPrefix(test1));
        Assert.assertEquals("", longestCommonPrefixV1.longestCommonPrefix(test2));
    }
}
