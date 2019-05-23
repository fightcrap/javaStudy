package com.pangxie.server.leetcode.easy.maximumsubarray;

/**
 * Create By fightingcrap On 2019/05/21
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
 * | MaximumSubarrayV1  -- 第53题 Maximum　Subarray
 * |
 * | @author fightingcrap
 **/
public class MaximumSubarrayV1 {

    public int maxSubArray(int[] nums) {

        if (nums.length < 1) {
            return 0;
        }

        int max = nums[0];
        int sum = max;
        for (int i = 1; i < nums.length; i++) {
            sum=sum + nums[i] < nums[i]?nums[i]:sum + nums[i];
            max=Math.max(sum,max);
        }
        return max;
    }

}
