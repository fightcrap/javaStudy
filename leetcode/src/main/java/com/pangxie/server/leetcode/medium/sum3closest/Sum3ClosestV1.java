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
 * | Sum3ClosestV1
 * |
 * | @author fightingcrap
 **/
public class Sum3ClosestV1 {
    public  int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        boolean isNegative = false;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {

            int diff = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int diffTemp = diff - (nums[start] + nums[end]);
                if (diffTemp > 0) {
                    start++;
                    if (diffTemp < temp) {
                        isNegative = false;
                        temp = diffTemp;
                    }
                }
                if (diffTemp < 0) {
                    end--;
                    if (-diffTemp < temp) {
                        isNegative = true;
                        temp = -diffTemp;
                    }
                }
                if (diffTemp == 0) {
                    return target;
                }

            }
        }
        return target-(isNegative?-temp:temp);
    }


}
