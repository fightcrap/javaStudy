package com.pangxie.server.leetcode.easy.validparentheses;

import java.util.LinkedList;

/**
 * Create By fightingcrap On 2019/05/10
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
 * | ValidParenthesesV3
 * |
 * | @author fightingcrap
 **/
public class ValidParenthesesV3 {

    public boolean isValid(String s) {

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char indexItem = chars[i];
            char temp = ' ';
            switch (indexItem) {
                case ']':
                    temp = '[';
                    break;
                case '}':
                    temp = '{';
                    break;
                case ')':
                    temp = '(';
                    break;
                default:
                    temp = ' ';
            }
            if (temp != ' ' && !find(chars, i, temp)) {
                return false;
            }
        }
        return String.valueOf(chars).trim().length() == 0;
    }

    private boolean find(char[] chars, int lastIndex, char target) {

        for (int i = lastIndex - 1; i >= 0; i--) {
            char temp = chars[i];
            if (temp == ' ' || temp == ')' || temp == ']' || temp == '}') {
                continue;
            }
            if (chars[i] != target) {
                return false;
            }
            //两者滞空，
            chars[i] = ' ';
            chars[lastIndex] = ' ';
            return true;
        }
        return false;
    }
}