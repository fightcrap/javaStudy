package com.pangxie.server.leetcode.easy.countandsay;

/**
 * Create By fightingcrap On 2019/05/16
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
 * | CountAndSayV1   -- 第38题 count and say
 * |
 * | @author fightingcrap
 **/
public class CountAndSayV1 {

    public String countAndSay(int n) {
        String first = "1";
        if (n <= 1) {
            return first;
        }

        StringBuilder stringBuilder = new StringBuilder(first);
        for (int i = 1; i < n; i++) {
            StringBuilder stringBuilder1 = new StringBuilder();
            char pre = stringBuilder.charAt(0);
            int count = 1;
            for (int m = 1; m < stringBuilder.length(); m++) {
                if (stringBuilder.charAt(m) != pre) {
                    stringBuilder1.append(count).append(pre);
                    pre = stringBuilder.charAt(m);
                    count = 1;
                    continue;
                }
                count++;
            }
            stringBuilder1.append(count).append(pre);
            stringBuilder = stringBuilder1;

        }

        return stringBuilder.toString();
    }
}
