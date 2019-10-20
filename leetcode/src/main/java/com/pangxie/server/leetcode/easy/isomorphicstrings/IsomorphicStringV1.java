package com.pangxie.server.leetcode.easy.isomorphicstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Create By fightingcrap On 2019/10/20
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
 * | IsomorphicStringV1
 * |
 * | @author fightingcrap
 **/
public class IsomorphicStringV1 {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char tc = t.charAt(i);
            if (!map.containsKey(c) && !map.containsValue(tc)) {
                map.put(c, tc);
                continue;
            }
            if (!Objects.equals(map.get(c), tc)) {
                return false;
            }
        }
        return true;
    }

}
