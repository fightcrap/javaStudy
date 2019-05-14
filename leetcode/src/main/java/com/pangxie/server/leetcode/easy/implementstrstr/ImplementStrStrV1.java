package com.pangxie.server.leetcode.easy.implementstrstr;

/**
 * Create By fightingcrap On 2019/05/14
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
 * | ImplementStrStrV1 --第28题 ImplementStrStr
 * |
 * | @author fightingcrap
 **/
public class ImplementStrStrV1 {

    public int strStr(String haystack, String needle) {

        if (haystack == null || "".equals(needle)) {
            return 0;
        }
        int len = haystack.length() - needle.length()+1;
        int needLen = needle.length();
        for (int i = 0; i < len; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            int m;
            for (m = 1; m < needle.length(); m++) {
                if (haystack.charAt(i + m) != needle.charAt(m)) {
                    break;
                }
            }

            if (m == needLen) {
                return i;
            }
        }

        return -1;

    }


}
