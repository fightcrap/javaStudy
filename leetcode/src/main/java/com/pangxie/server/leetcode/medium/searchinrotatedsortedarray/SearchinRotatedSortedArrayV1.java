package com.pangxie.server.leetcode.medium.searchinrotatedsortedarray;

/**
 * Create By fightingcrap On 2020/01/18
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
 * | SearchinRotatedSortedArrayV1
 * |
 * | @author fightingcrap
 **/
public class SearchinRotatedSortedArrayV1 {
    public int search(int[] nums, int target) {

        return findValue(nums, 0, nums.length - 1, target);
    }

    private int findValue(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int index = (start + end) / 2;
        if (nums[index] == target) {
            return index;
        }
        int result = -1;
        result = findValue(nums, start, index - 1, target);
        if (result != -1) {
            return result;
        }
        return findValue(nums, index + 1, end, target);
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArrayV1 searchinRotatedSortedArrayV1 = new SearchinRotatedSortedArrayV1();

        System.out.println(searchinRotatedSortedArrayV1.search(new int[]{3, 4, 5, 6, 1, 2}, 2));
    }
}
