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
    public void rotate(int[] nums, int k) {

        if (k == 0 || nums.length <= 0) {
            return;
        }
        k = k % nums.length;
        while (k > 0) {
            int length=nums.length;
            int temp = nums[length-1];
            for (int i = nums.length-1; i >0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
    }


}
