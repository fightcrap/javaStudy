package com.pangxie.server.leetcode.medium.lettercombinationsofaphonenumber;

import java.util.*;
import java.util.stream.Stream;

/**
 * Create By fightingcrap On 2020/01/02
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
 * | LetterCombinationsOfAPhoneNumberV1
 * |
 * | @author fightingcrap
 **/
public class LetterCombinationsOfAPhoneNumberV1 {

    private static String[] list = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new LinkedList<>();
        for (char c : digits.toCharArray()) {
            int index = c - '2';
            if (result.isEmpty()) {
                insertAndReplace(result, list[index].toCharArray());
                continue;
            }
            insertAndReplace(result, list[index].toCharArray());


        }
        return result;

    }


    private boolean insertAndReplace(List<String> list, char[] chars) {

        if (list.isEmpty()) {
            for (char c1 : chars) {
                list.add(c1 + "");
            }
            return true;
        }
        int len = list.size();
        for (int i = 0; i < len; i++) {
            for (char s : chars) {
                list.add(list.get(i) + s);
            }
        }
        for (int i = 0; i < len; i++) {
            list.remove(0);
        }

        return true;

    }

}
