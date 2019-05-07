package com.pangxie.server.leetcode.easy.reverseinteger;

/**
 * Create By fightingcrap On 2019/05/06
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
 * | ReverseIntegerV2
 * |
 * | @author fightingcrap
 **/
public class ReverseIntegerV2 {

    public int reverse(int x) {
        //如果是负数，则变化成正数
        long temp = x;
        boolean isMinus = false;
        if (x < 0) {
            temp = -temp;
            isMinus = true;
        }
        long value = 0;
        //获取长度。
        while (temp / 10 != 0 || temp % 10 != 0) {
            long remainder = temp % 10;

            value = value * 10 + remainder;
            if (value > Integer.MAX_VALUE) {
                return 0;
            }

            temp = temp / 10;
        }

        return (int) value * (isMinus ? -1 : 1);
    }
}
