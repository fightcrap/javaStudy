package com.pangxie.server.leetcode.easy.removeduplicatesfromsortedarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Create By fightingcrap On 2019/05/13
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
 * | RemoveDuplicatesFromSortedArrayV1  -- 第26题 Remove Duplicates From Sorted Array
 * |
 * | @author fightingcrap
 **/
public class RemoveDuplicatesFromSortedArrayV1 {

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }
        int number = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[number]) {
                number++;
                nums[number] = nums[i];
            }
        }

        return number + 1;

    }
}
