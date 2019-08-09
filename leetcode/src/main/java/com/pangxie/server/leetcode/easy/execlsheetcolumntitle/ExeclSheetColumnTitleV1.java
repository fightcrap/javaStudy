package com.pangxie.server.leetcode.easy.execlsheetcolumntitle;

/**
 * Create By fightingcrap On 2019/08/07
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
 * | ExeclSheetColumnTitle
 * |
 * | @author fightingcrap
 **/
public class ExeclSheetColumnTitleV1 {

    public static String convertToTitle(int n) {

        char normal = 'A';
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            n--;
            stringBuilder.insert(0,(char)(n % 26 + normal));
            n = n / 26;
        }

        return stringBuilder.toString();

    }
}
