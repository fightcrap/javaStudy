package com.pangxie.server.leetcode.easy.excelsheetcolumnnumber;

/**
 * Create By fightingcrap On 2019/09/09
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
 * | ExcelSheetColumnNumberV1
 * |
 * | @author fightingcrap
 **/
public class ExcelSheetColumnNumberV1 {

    public int titleToNumber(String s) {

        if (s == null || s.length() < 1) {
            return 0;
        }
        int pagesize = 'Z' - 'A'+1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int number = (s.charAt(i) - 'A' + 1);
            result = result * pagesize + number;
        }

        return result;
    }


}
