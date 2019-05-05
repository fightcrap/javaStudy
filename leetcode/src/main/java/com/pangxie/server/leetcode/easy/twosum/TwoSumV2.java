package com.pangxie.server.leetcode.easy.twosum;

import sun.jvm.hotspot.utilities.Assert;

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
 * | TwoSumV2  -- 两数合，对应leetcode第一题
 * |
 * | @author fightingcrap
 **/
public class TwoSumV2 {

    public static void main(String[] args) {

        twoSum(new int[]{3,2,4},6) ;
    }

    public static int[] twoSum(int[] nums, int target) {

        //先转化为hashmap
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            //如果是本身，就跳过
            if (integer != null && integer!=i) {
                return new int[]{i, integer};
            }
        }

        return new int[]{};
    }
}
