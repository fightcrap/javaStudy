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
 * | LengthOfLastWordV1
 * |
 * | @author fightingcrap
 **/
public class LengthOfLastWordV1 {

    public int lengthOfLastWord(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }
        int count = 0;
        int lastCount = count;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                lastCount = count == 0 ? lastCount : count;
                count = 0;
                continue;
            }
            count++;
        }
        return count == 0 ? lastCount : count;
    }
}
