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
 * | MajorityElementV1
 * |
 * | @author fightingcrap
 **/
public class MajorityElementV1 {

    public int majorityElement(int[] nums) {

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        int mid = len / 2;
        for (int i = 0; i < len; i++) {
            int temp=nums[i];
            Integer value = map.get(temp);
            if (value == null) {
                value = 0;
            }
            value++;
            if (value > mid) {
                return temp;
            }
            map.put(temp, value );
        }
        return 0;

    }


}
