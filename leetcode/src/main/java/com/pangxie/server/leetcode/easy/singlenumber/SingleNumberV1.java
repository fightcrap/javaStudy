package com.pangxie.server.leetcode.easy.singlenumber;

/**
 * Create By fightingcrap On 2019/06/26
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
 * | SingleNumberV1
 * |
 * | @author fightingcrap
 **/
public class SingleNumberV1 {

    public int singleNumber(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;

    }

}
