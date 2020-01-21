package com.pangxie.server.leetcode.medium.nextpermutation;

/**
 * Create By fightingcrap On 2020/01/12
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
 * | NextPermutationV1
 * |
 * | @author fightingcrap
 **/
public class NextPermutationV1 {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 1;
        for (; i - 1 >= 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }

        //转化一下
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
        }

        for (int m = nums.length - 1; m >= i; m--) {
            if (nums[m] >nums[i-1]) {
                swap(nums, m, i-1);
                reverse(nums,i,nums.length-1);
                break;
            }
        }


    }


    private void swap(int[] nums, int index, int index1) {
        nums[index] = nums[index] ^ nums[index1];
        nums[index1] = nums[index] ^ nums[index1];
        nums[index] = nums[index] ^ nums[index1];
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutationV1 nextPermutationV1 = new NextPermutationV1();
        nextPermutationV1.nextPermutation(new int[]{1, 2, 3});
        System.out.println();
    }
}
