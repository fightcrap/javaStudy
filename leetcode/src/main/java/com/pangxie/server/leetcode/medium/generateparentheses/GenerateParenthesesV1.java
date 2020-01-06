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
 * | GenerateParenthesesV1
 * |
 * | @author fightingcrap
 **/
public class GenerateParenthesesV1 {
    public List<String> generateParenthesis(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>(n * 2);
        result.add("(");
        for (int j = 1; j < n * 2; j++) {
            int len = result.size();
            for (int i = 0; i < len; i++) {
                String value = result.get(i);
                int count = 0;
                int temp = 0;
                for (char c : value.toCharArray()) {
                    if ('(' == c) {
                        count++;
                        temp++;
                    } else {
                        count--;
                    }
                }
                if (count!=0) {
                    result.add(value + ")");
                }
                if(temp<n){
                    result.add(value + "(");
                }
            }
            result = result.subList(len, result.size());
        }

        return result;
    }



    public static void main(String[] args) {
        GenerateParenthesesV1 generateParenthesesV1 = new GenerateParenthesesV1();
        System.out.println(generateParenthesesV1.generateParenthesis(3));
    }
}
