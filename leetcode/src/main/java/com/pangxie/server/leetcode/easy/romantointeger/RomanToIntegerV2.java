package com.pangxie.server.leetcode.easy.romantointeger;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By fightingcrap On 2019/05/08
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
 * | RomanToIntegerV2
 * |
 * | @author fightingcrap
 **/
public class RomanToIntegerV2 {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>(7);
        map.put("I", 1);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        char last = s.charAt(0);
        int result = map.get(String.valueOf(last));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            String temp = String.valueOf(new char[]{last, c});
            Integer integer = map.get(temp);
            if (integer != null) {
                result = result - 2 * map.get(String.valueOf(last));
            }
            result += map.get(String.valueOf(c));
            last = c;
        }
        return result;


    }
}
