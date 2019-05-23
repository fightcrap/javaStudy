package com.pangxie.server.leetcode.easy.sqrt;

/**
 * Create By fightingcrap On 2019/05/23
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
 * | SqrtV2
 * |
 * | @author fightingcrap
 **/
public class SqrtV2 {
    public  int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int start = 0;
        int end = x;
        while (start <= end) {
            int index = (start + end) / 2;
            long sum = 1L * index * index;
            if (sum > x) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return end;
    }
}
