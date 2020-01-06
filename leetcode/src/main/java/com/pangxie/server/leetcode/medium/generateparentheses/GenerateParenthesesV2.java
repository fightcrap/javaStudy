package com.pangxie.server.leetcode.medium.generateparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By fightingcrap On 2020/01/06
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
 * | GenerateParenthesesV2
 * |
 * | @author fightingcrap
 **/
public class GenerateParenthesesV2 {
    public List<String> generateParenthesis(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>(n * 2);

        addChar("(", 1, 0, n, result);
        return result;
    }

    private void addChar(String s, int left, int right, int n, List<String> list) {
        if (left == right && left == n) {
            list.add(s);
        }

        if (left < n) {
            addChar(s + "(", left + 1, right, n, list);
        }
        if (right < n && left > right) {
            addChar(s + ")", left, right + 1, n, list);
        }

    }

    public static void main(String[] args) {
        GenerateParenthesesV2 generateParenthesesV1 = new GenerateParenthesesV2();
        System.out.println(generateParenthesesV1.generateParenthesis(3));
    }
}
