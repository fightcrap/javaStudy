package com.pangxie.server.leetcode.easy.searchinsertposition;

/**
 * Create By fightingcrap On 2019/05/15
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
 * | SearchInsertPositionV2  --第35题，测试见test
 * |
 * | @author fightingcrap
 **/
public class SearchInsertPositionV2 {

    public int searchInsert(int[] nums, int target) {
        if (nums.length < 0) {
            return 0;
        }

        return serch(nums, 0, nums.length, target);

    }

    private int serch(int[] nums, int start, int end, int target) {

        if (start >= end) {
            return start;
        }

        int mod = (start + end) / 2;
        if (nums[mod] == target) {
            return mod;
        }
        if (nums[mod] < target) {
            return serch(nums, mod + 1, end, target);
        }

        if (nums[mod] > target) {
            return serch(nums, start, mod, target);
        }
        return 0;

    }
}
