package com.pangxie.server.leetcode.easy.removeelement;

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
 * | RemoveElementV1
 * |
 * | @author fightingcrap
 **/
public class RemoveElementV1 {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        int len = nums.length;
        for (int i = 0; i < len  - index; i++) {
            if (nums[i] != val) {
                continue;
            }

            int temp = len - 1 - index;
            nums[i] = nums[i] ^ nums[temp];
            nums[temp] = nums[temp] ^ nums[i];
            nums[i] = nums[temp] ^ nums[i];
            i--;
            index++;
        }

        return len - index;


    }

}
