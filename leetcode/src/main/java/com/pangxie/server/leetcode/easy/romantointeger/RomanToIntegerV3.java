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
 * | RomanToIntegerV3
 * |
 * | @author fightingcrap
 **/
public class RomanToIntegerV3 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char last = s.charAt(0);
        int result = map.get(last);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.get(last) < map.get(c)) {
                result = result - 2 * map.get(last);
            }
            result += map.get(c);
            last = c;
        }
        return result;


    }
}
