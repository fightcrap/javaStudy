package com.pangxie.server.leetcode.medium.integertoroman;

import java.util.*;

/**
 * Create By fightingcrap On 2019/11/11
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
 * | IntegerToRomanV1
 * |
 * | @author fightingcrap
 **/
public class IntegerToRomanV1 {

    private static Map<Integer, String> map = new HashMap<>();

    private static List<Integer> list = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");


    }

    public String intToRoman(int num) {

        int index = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int intValue = list.get(index);
            if (intValue > num) {
                index++;
                continue;
            }
            num = num - intValue;
            result.append(map.get(intValue));
        }
        return result.toString();
    }
}
