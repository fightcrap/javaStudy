package com.pangxie.server.leetcode.medium.findfirstandlastpositionofelementinsortedarray;

/**
 * Create By fightingcrap On 2020/01/21
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
 * | FindFirstAndLastPositionOfElementInSortedArrayV2
 * |
 * | @author fightingcrap
 **/
public class FindFirstAndLastPositionOfElementInSortedArrayV2 {
    public int[] searchRange(int[] nums, int target) {

        int index = dichotomySearch(nums, target, 0, nums.length - 1);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        //在根据二分来找前一个数；
        int first = index;
        int last = index;
        while (true) {

            int temp = dichotomySearch(nums, target, 0, first - 1);
            if (temp < 0) {
                break;
            }
            first = temp;
        }

        while (true) {

            int temp = dichotomySearch(nums, target, last + 1, nums.length - 1);
            if (temp < 0) {
                break;
            }
            last = temp;
        }
        return new int[]{first,last};
    }

    private int dichotomySearch(int[] nums, int target, int start, int end) {

        while (start <= end) {

            int index = (start + end) / 2;
            if (nums[index] == target) {
                return index;
            }

            if (nums[index] > target) {
                end = index - 1;
            }
            if (nums[index] < target) {
                start = index + 1;
            }
        }
        return -1;
    }


}
