package com.pangxie.server.leetcode.easy.plusone;

import java.math.BigDecimal;

/**
 * Create By fightingcrap On 2019/05/22
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
 * | PlusOneV1
 * |
 * | @author fightingcrap
 **/
public class PlusOneV1 {
    public int[] plusOne(int[] digits) {
        if (digits.length < 1) {
            return digits;
        }
        int len = digits.length;

        int[] result = new int[len];
        int[] result1 = new int[len + 1];
        int add = 1;
        for (int i = len - 1; i >= 0; i--) {
            int temp = add + digits[i];
            add = temp / 10;
            result[i] = temp % 10;
            result1[i + 1] = result[i];
        }
        if (add != 0) {
            result1[0] = add;
            return result1;
        }
        return result;
    }
}
