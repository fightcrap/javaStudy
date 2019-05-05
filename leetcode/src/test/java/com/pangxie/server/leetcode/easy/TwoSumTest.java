package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.twosum.TwoSumV1;
import com.pangxie.server.leetcode.easy.twosum.TwoSumV2;
import com.pangxie.server.leetcode.easy.twosum.TwoSumV3;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Create By fightingcrap On 2019/05/05
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
 * | TwoSumV2Test
 * |
 * | @author fightingcrap
 **/
public class TwoSumTest {

    @Test
    public void test(){
        int[] temp=new int[]{2,7,11,15};
        int target=9;
        int[] trueResult=new int[]{0,1};
        Assert.assertTrue(Arrays.equals(TwoSumV1.twoSum(temp,target),trueResult));
        Assert.assertTrue(Arrays.equals(TwoSumV2.twoSum(temp,target),trueResult));
        Assert.assertTrue(Arrays.equals(TwoSumV3.twoSum(temp,target),trueResult));

    }
}
