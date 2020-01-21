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
 * | FindFirstAndLastPositionOfElementInSortedArrayV1
 * |
 * | @author fightingcrap
 **/
public class FindFirstAndLastPositionOfElementInSortedArrayV1 {
    public int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            int index = (start + end) / 2;
            if (nums[index] == target) {
                int first = index ;
                int last = index ;
                while (true) {
                    if (first-1 < 0 || nums[first - 1] != target) {
                        break;
                    }
                    first--;
                }

                while (true) {
                    if (last + 1 > nums.length - 1 || nums[last + 1] != target) {
                        break;
                    }
                    last++;
                }
                return new int[]{first, last};
            }

            if (nums[index] > target) {
                end = index - 1;
            }
            if (nums[index] < target) {
                start = index + 1;
            }
        }

        return new int[]{-1,-1};

    }


}
