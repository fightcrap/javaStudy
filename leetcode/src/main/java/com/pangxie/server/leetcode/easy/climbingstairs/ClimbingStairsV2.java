package com.pangxie.server.leetcode.easy.climbingstairs;

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
 * | ClimbingStairsV2
 * |
 * | @author fightingcrap
 **/
public class ClimbingStairsV2 {
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}
