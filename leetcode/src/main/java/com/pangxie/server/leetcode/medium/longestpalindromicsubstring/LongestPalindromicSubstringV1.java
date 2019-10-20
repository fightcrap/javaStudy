package com.pangxie.server.leetcode.medium.longestpalindromicsubstring;

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
 * | LongestPalindromicSubstringV1
 * |
 * | @author fightingcrap
 **/
public class LongestPalindromicSubstringV1 {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = i;
            while (true) {
                int indexTemp = s.indexOf(c, index + 1);

                if (indexTemp != -1) {
                    if(indexTemp-i<result.length()){
                        index=indexTemp;
                        continue;
                    }
                    String temp = s.substring(i, indexTemp + 1);

                    if (isPalindromic(temp) && temp.length() > result.length()) {
                        result = temp;
                    }
                    index = indexTemp ;
                } else {
                    break;
                }
            }
            if (result.length() == 0) {
                result += c;
            }
        }
        return result;
    }

    private boolean isPalindromic(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
