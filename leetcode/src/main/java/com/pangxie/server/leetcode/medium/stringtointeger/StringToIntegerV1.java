package com.pangxie.server.leetcode.medium.stringtointeger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create By fightingcrap On 2019/11/08
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
 * | StringToIntegerV1
 * |
 * | @author fightingcrap
 **/
public class StringToIntegerV1 {


    public int myAtoi(String str) {

        str = str.trim();
        if (str == null || str.length() <= 0) {
            return 0;
        }
        long result = 0;
        boolean isMinus = false;
        boolean isHasSpecial = false;
        boolean isStart = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {
                if (isStart || isHasSpecial) {
                    break;
                }
                isHasSpecial = true;
                isMinus = c == '-';
                continue;
            }
            isStart=true;

            if (c > '9' || c < '0') {
                break;
            }
            result = result * 10 + c - '0';
            if (isMinus && result > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }


        }
        return (int) ((isMinus ? -1 : 1) * result);


    }

    public static void main(String[] args) {
        System.out.println(new StringToIntegerV1().myAtoi("-2147483647"));
    }
}
