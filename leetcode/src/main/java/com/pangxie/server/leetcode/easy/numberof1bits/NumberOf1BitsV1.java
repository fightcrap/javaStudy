package com.pangxie.server.leetcode.easy.numberof1bits;

/**
 * Create By fightingcrap On 2019/10/12
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
 * | NumberOf1BitsV1
 * |
 * | @author fightingcrap
 **/
public class NumberOf1BitsV1 {
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < Integer.SIZE && n != 0; i++) {
            result += n & 1;
            n >>= 1;
        }

        return result;
    }
}
