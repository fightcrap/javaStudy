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
 * | TwoSumV3
 * |
 * | @author fightingcrap
 **/
public class TwoSumV3 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int differ = target - nums[i];
            Integer result = map.get(differ);
            if (null != result) {
                return new int[]{result,i };
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
