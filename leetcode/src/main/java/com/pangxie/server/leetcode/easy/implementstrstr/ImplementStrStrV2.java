package com.pangxie.server.leetcode.easy.implementstrstr;

/**
 * Create By fightingcrap On 2019/05/14
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
 * | ImplementStrStrV2 --第28题 ImplementStrStr
 * |
 * | @author fightingcrap
 **/
public class ImplementStrStrV2 {

    public int strStr(String haystack, String needle) {

        if (haystack == null ) {
            return 0;
        }

        return haystack.indexOf(needle);
    }

}
