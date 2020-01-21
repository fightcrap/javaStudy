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
 * | SearchinRotatedSortedArrayV2
 * |
 * | @author fightingcrap
 **/
public class SearchinRotatedSortedArrayV2 {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int index = (start + end) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] > nums[start]) {
                if (nums[start] <= target && nums[index] >= target) {
                    end = index - 1;
                    continue;
                }
                if (nums[index] < target||nums[start]>target) {
                    start = index + 1;
                    continue;
                }

                end --;

            }

            if (nums[index] <= nums[start]) {
                if (nums[end] < target) {
                    end = index - 1;
                    continue;
                }
                if (nums[end] > target&&nums[index]<=target) {
                    start =index+1;
                    continue;
                }
                start++;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArrayV2 searchinRotatedSortedArrayV1 = new SearchinRotatedSortedArrayV2();

        System.out.println(searchinRotatedSortedArrayV1.search(new int[]{4,5,6,7,0,1,2}, 2));
    }
}
