package com.pangxie.server.leetcode.medium.sum3closest;

import java.util.Arrays;

/**
 * Create By fightingcrap On 2020/01/01
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
 * | Sum3ClosestV2 --代码优化版本
 * |
 * | @author fightingcrap
 **/
public class Sum3ClosestV2 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        boolean isNegative = false;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int diffTemp = target - (nums[i] + nums[start] + nums[end]);
                if (diffTemp > 0) {
                    start++;
                }
                if (diffTemp < 0) {
                    end--;
                }
                if (diffTemp == 0) {
                    return target;
                }
                if (Math.abs(diffTemp) < temp) {
                    temp = Math.abs(diffTemp);
                    isNegative = diffTemp < 0;
                }

            }
        }
        return target - (isNegative ? -temp : temp);
    }
}
