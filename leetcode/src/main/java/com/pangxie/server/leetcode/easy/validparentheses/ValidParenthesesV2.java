package com.pangxie.server.leetcode.easy.validparentheses;

import java.util.LinkedList;
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
 * | ValidParenthesesV2
 * |
 * | @author fightingcrap
 **/
public class ValidParenthesesV2 {

    public boolean isValid(String s) {

        LinkedList<Character> linkedList=new LinkedList();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char indexChar = s.charAt(i);
            switch (indexChar) {
                case '{':
                    linkedList.addFirst('}');
                    break;
                case '[':
                    linkedList.addFirst(']');
                    break;
                case '(':
                    linkedList.addFirst(')');
                    break;
                default:
                    if (linkedList.size() == 0) {
                        return false;
                    } else if (linkedList.getFirst() != indexChar) {
                        return false;
                    }
                    linkedList.remove(0);
            }

        }

        return linkedList.size() == 0;
    }

}
