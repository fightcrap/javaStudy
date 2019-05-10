package com.pangxie.server.leetcode.easy.validparentheses;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
 * | ValidParenthesesV1
 * |
 * | @author fightingcrap
 **/
public class ValidParenthesesV1 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char indexChar = s.charAt(i);
            switch (indexChar) {
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.size() == 0) {
                        return false;
                    } else if (stack.pop() != indexChar) {
                        return false;
                    }
            }

        }
        return stack.size() == 0;
    }
}
