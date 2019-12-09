package com.pangxie.server.leetcode.medium.sum3;

import java.util.*;

/**
 * Create By fightingcrap On 2019/11/12
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
 * | Sum3V1
 * |
 * | @author fightingcrap
 **/
public class Sum3V1 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>> lists = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            int number = nums[i];
            int sum = -number;
            int satrt = i + 1;

            int end = nums.length - 1;
            while (satrt < end) {
                if (nums[satrt] + nums[end] == sum) {
                    lists.add(Arrays.asList(number, nums[satrt], nums[end]));
                    satrt++;
                    end--;
                } else if (nums[satrt] + nums[end] < sum) {
                    satrt++;
                } else {
                    end--;
                }
            }
        }
        return new ArrayList<>(lists);

    }

    public static void main(String[] args) {
        Sum3V1 sum3V1 = new Sum3V1();
        System.out.println(sum3V1.threeSum(new int[]{0, 0, 0, 0}).size());
    }
}
