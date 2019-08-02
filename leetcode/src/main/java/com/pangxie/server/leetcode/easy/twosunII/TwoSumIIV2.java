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
 * | TwoSumIIV2
 * |
 * | @author fightingcrap
 **/
public class TwoSumIIV2 {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length <= 1) {
            return new int[]{};
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int dex = target - numbers[start];
            if (dex < numbers[end]) {
                end--;
            }else if (dex == numbers[end]) {
                return new int[]{start + 1, end + 1};
            }else if(dex>numbers[end]){
                start++;
            }
        }
        return new int[]{};

    }
}
