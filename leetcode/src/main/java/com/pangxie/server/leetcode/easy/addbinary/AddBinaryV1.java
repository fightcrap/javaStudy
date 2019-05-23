package com.pangxie.server.leetcode.easy.addbinary;

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
 * | AddBinaryV1
 * |
 * | @author fightingcrap
 **/
public class AddBinaryV1 {
    public static String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int add = 0;
        while (lenA >= 0 || lenB >= 0 || add > 0) {
            int result = (lenA >= 0 ? a.charAt(lenA) - '0' : 0) + (lenB >= 0 ? b.charAt(lenB) - '0' : 0) + add;
            add = result / 2;
            stringBuilder.append(result % 2);
            lenA--;
            lenB--;
        }

        return stringBuilder.reverse().toString();

    }


}
