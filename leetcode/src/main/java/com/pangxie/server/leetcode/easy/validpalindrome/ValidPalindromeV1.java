package com.pangxie.server.leetcode.easy.validpalindrome;

/**
 * Create By fightingcrap On 2019/06/25
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
 * | ValidPalindromeV1
 * |
 * | @author fightingcrap
 **/
public class ValidPalindromeV1 {

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int equals = 'a' - 'A';

        int index = 0;
        int end = s.length() - 1;
        while (index < end) {
            char left = getLowerChar(s.charAt(index));
            if (!isUseFullChar(left)) {
                index++;
                continue;
            }
            char right = getLowerChar(s.charAt(end));
            if (!isUseFullChar(right)) {
                end--;
                continue;
            }

            int temp = left - right;
            if (temp == 0 || temp == equals || temp == -equals) {
                index++;
                end--;
                continue;
            }
            return false;

        }
        return true;

    }

    private static boolean isUseFullChar(char c) {

        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    private static char getLowerChar(char c) {

        if (c >= 'A' && c <= 'Z') {
            return (char) (c - 'A'+'a');
        }
        return c;
    }


}
