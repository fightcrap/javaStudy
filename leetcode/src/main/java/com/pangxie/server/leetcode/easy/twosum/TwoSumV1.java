package com.pangxie.server.leetcode.easy.twosum;

import java.util.HashMap;
import java.util.Map;

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
 * | TwoSumV1
 * |
 * | @author fightingcrap
 **/
public class TwoSumV1 {

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int differ = target - nums[i];

            for (int m = i + 1; m < nums.length; m++) {
                if (differ == nums[m]) {
                    return new int[]{i, m};
                }
            }
        }
        return new int[]{};
    }
}
