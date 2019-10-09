package com.pangxie.server.leetcode.easy.rotatearray;

/**
 * Create By fightingcrap On 2019/10/09
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
 * | RotateArrayV1
 * |
 * | @author fightingcrap
 **/
public class RotateArrayV1 {
    public static void rotate(int[] nums, int k) {

        if (k == 0 || nums.length <= 0) {
            return;
        }
        while (k > 0) {
            int temp = nums[nums.length-1];
            for (int i = nums.length-1; i >0; i--) {

                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
