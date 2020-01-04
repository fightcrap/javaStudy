package com.pangxie.server.leetcode.medium.foursum;

import java.util.*;

/**
 * Create By fightingcrap On 2020/01/03
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
 * | FourSumV1
 * |
 * | @author fightingcrap
 **/
public class FourSumV1 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int diff = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int start = j + 1;
                int end = nums.length - 1;
                int diffTemp = diff - nums[j];
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (diffTemp == sum) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                    }
                    if (diffTemp < sum) {
                        end--;
                    }
                    if (diffTemp > sum) {
                        start++;
                    }
                }

            }
        }
        return new ArrayList<>(set);

    }


}
