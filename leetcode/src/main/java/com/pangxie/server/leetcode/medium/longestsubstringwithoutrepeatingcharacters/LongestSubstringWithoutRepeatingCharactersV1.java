package com.pangxie.server.leetcode.medium.longestsubstringwithoutrepeatingcharacters;

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
 * | LongestSubstringWithoutRepeatingCharactersV1
 * |
 * | @author fightingcrap
 **/
public class LongestSubstringWithoutRepeatingCharactersV1 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() <= 0) {
            return 0;
        }
        String temp = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            //如果在临时文件中存在，则获取
            if (temp.indexOf(c) != -1) {
                //如果结果字段小，则两者替换
                if (result.length() < temp.length()) {
                    result = temp;
                }
                temp = temp.substring(temp.indexOf(c)+1);
            }
            temp += c;
        }

        return Math.max(result.length(),temp.length());

    }

}
