package com.pangxie.server.leetcode.easy.romantointeger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
 * | RomanToIntegerV1
 * |
 * | @author fightingcrap
 **/
public class RomanToIntegerV1 {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>(16);
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

        int result = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            String temp = String.valueOf(c);
            if ((c == 'I' || c == 'X' || c == 'C') && (i + 1) < s.length()) {
                String m = String.valueOf(new char[]{c, s.charAt(i + 1)});
                if (map.get(m) != null) {
                    temp = m;
                    i++;
                }
            }
            result += map.get(temp);

        }
        return result;


    }
}
