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
 * | SearchInsertPositionV1  --第35题，测试见test
 * |
 * | @author fightingcrap
 **/
public class SearchInsertPositionV1 {

    public int searchInsert(int[] nums, int target) {
        if (nums.length < 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;

    }

}
