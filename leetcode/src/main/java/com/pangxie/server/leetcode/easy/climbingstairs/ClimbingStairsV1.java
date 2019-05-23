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
 * | ClimbingStairsV1
 * |
 * | @author fightingcrap
 **/
public class ClimbingStairsV1 {

    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int one = climbStairs(n - 1);
        int two = climbStairs(n - 2);
        return one+two;
    }
}
