package com.pangxie.server.leetcode.easy.reversebits;

/**
 * Create By fightingcrap On 2019/10/10
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
 * | ReverseBitsV1
 * |
 * | @author fightingcrap
 **/
public class ReverseBitsV1 {
    public  int reverseBits(int n) {

        int result = 0;
        for(int i=0;i<Integer.SIZE;i++){

            result =( result << 1)+((n & 1) == 1?1:0);
            n = n >> 1;
        }
        return result;
    }


}
