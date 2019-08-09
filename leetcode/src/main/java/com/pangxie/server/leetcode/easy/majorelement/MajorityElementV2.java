package com.pangxie.server.leetcode.easy.majorelement;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By fightingcrap On 2019/08/09
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
 * | MajorityElementV2
 * |
 * | @author fightingcrap
 **/
public class MajorityElementV2 {

    public int majorityElement(int[] nums) {

        int result = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {

            if (len == 0) {
                result = nums[i];
                len = 1;
                continue;
            }
            if (result == nums[i]) {
                len++;
            } else {
                len--;
            }
        }
        return result;

    }
}
