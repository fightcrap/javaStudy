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
 * | SearchInsertPositionV3  --第35题，测试见test
 * |
 * | @author fightingcrap
 **/
public class SearchInsertPositionV3 {

    public int searchInsert(int[] nums, int target) {
        if (nums.length < 0) {
            return 0;
        }
        int index = 0;
        int len = nums.length;
        while (index < len) {
            int mod = (index + len) / 2;
            if (nums[mod] == target) {
                return mod;
            } else if (nums[mod] > target) {
                len = mod;
            } else {
                index = mod + 1;
            }
        }

        return index;

    }
}
