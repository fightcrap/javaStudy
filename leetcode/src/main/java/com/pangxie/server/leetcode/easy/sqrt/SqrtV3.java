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
 * | SqrtV3
 * |
 * | @author fightingcrap
 **/
public class SqrtV3 {
    public  int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        return (int)Math.sqrt(x);
    }
}
