package com.pangxie.server.leetcode.easy.lengthoflastword;

/**
 * Create By fightingcrap On 2019/05/21
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
 * | LengthOfLastWordV2
 * |
 * | @author fightingcrap
 **/
public class LengthOfLastWordV2 {
    public int lengthOfLastWord(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }
        s = s.trim();

        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
