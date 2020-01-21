package com.pangxie.server.leetcode.medium.dividetwointegers;

/**
 * Create By fightingcrap On 2020/01/09
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
 * | DivideTwoIntegersV1
 * |
 * | @author fightingcrap
 **/
public class DivideTwoIntegersV1 {
    public int divide(int dividend, int divisor) {


        boolean isNotNegative = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
        if (divisor == 1 || divisor == -1) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            return dividend * divisor;
        }
        long temp = 0;
        long divisorTemp=0;
        if (dividend == Integer.MIN_VALUE) {
            temp = Integer.MAX_VALUE + 1L;
        } else {
            temp = Math.abs(dividend);
        }

        if (divisor == Integer.MIN_VALUE) {
            divisorTemp = Integer.MAX_VALUE + 1L;
        } else {
            divisorTemp = Math.abs(divisor);
        }

        int result = 0;
        while (temp >= divisorTemp) {

            int i=0;
            for (; i < 31; i++) {

                long value = divisorTemp * 1L << i;

                if (value > temp) {
                    temp = temp - (divisorTemp << (i - 1));
                    if (i - 1 == 0) {
                        result += 1;
                        break;
                    }
                    result += 1 << (i - 1);
                    break;
                }
            }
            if(i==31){
                temp=temp-Integer.MAX_VALUE;
                result += 1 <<  30;
            }

        }
        return result * (isNotNegative ? 1 : -1);
    }

}
