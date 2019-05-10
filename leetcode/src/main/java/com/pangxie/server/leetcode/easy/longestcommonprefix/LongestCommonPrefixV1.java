package com.pangxie.server.leetcode.easy.longestcommonprefix;

/**
 * Create By fightingcrap On 2019/05/09
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
 * | LongestCommonPrefixV1 --最长公共前缀字符串,测试见test
 * |
 * | @author fightingcrap
 **/
public class LongestCommonPrefixV1 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String st = strs[0];
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < st.length(); i++) {
            char s = st.charAt(i);
            for (int m = 1; m < strs.length; m++) {
                if (strs[m].length() <= i || strs[m].charAt(i) != s) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
