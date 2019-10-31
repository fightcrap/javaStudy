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
 * | ZigzagConversionV1
 * |
 * | @author fightingcrap
 **/
public class ZigzagConversionV1 {

    public String convert(String s, int numRows) {

        if(numRows<=1){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            int index = i;
            boolean isNext = false;
            int lastIndex = i;
            while (index < s.length() || (isNext && lastIndex + numRows * 2 - 2 < s.length())) {
                if (index == i) {
                    stringBuilder.append(s.charAt(index));
                    index = index + 2 * numRows - 2 * (i == numRows - 1 ? 0 : i) - 2;
                    lastIndex = i;
                } else {
                    if (isNext  ) {
                        if(i != 0 && i != numRows - 1){
                            stringBuilder.append(s.charAt(lastIndex + numRows * 2 - 2));
                        }
                        lastIndex = lastIndex + numRows * 2 - 2;
                        isNext = false;
                        continue;
                    }
                    stringBuilder.append(s.charAt(index));

                    index = index + numRows * 2 - 2;
                    isNext = true;
                }
            }

        }
        return stringBuilder.toString();
    }


}
