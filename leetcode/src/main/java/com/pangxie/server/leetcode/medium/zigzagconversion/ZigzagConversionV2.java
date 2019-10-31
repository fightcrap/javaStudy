package com.pangxie.server.leetcode.medium.zigzagconversion;

/**
 * Create By fightingcrap On 2019/10/31
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
 * | ZigzagConversionV2
 * |
 * | @author fightingcrap
 **/
public class ZigzagConversionV2 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++) {
                stringBuilders[j].append(s.charAt(i++));
            }
            for (int m = numRows - 2; m > 0 && i < s.length(); m--) {
                stringBuilders[m].append(s.charAt(i++));
            }

        }

        for (int k = 1; k < numRows; k++) {

            stringBuilders[0].append(stringBuilders[k]);
        }
        return stringBuilders[0].toString();
    }
}