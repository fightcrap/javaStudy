package com.pangxie.server.leetcode.easy.twosunII;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By fightingcrap On 2019/08/02
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
 * | TwoSumII
 * |
 * | @author fightingcrap
 **/
public class TwoSumIIV1 {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        if (numbers.length <= 1) {
            return new int[]{};
        }

        for (int i = 0; i < numbers.length; i++) {
            int dex = target - numbers[i];
            Integer value = map.get(dex);
            if (value != null) {
                return new int[]{value+1, i+1};
            }
            map.put(numbers[i],i);
        }
        return new int[]{};

    }
}
