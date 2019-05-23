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
 * | SqrtV1
 * |
 * | @author fightingcrap
 **/
public class SqrtV1 {
    public static int mySqrt(int x) {

        if (x <= 0) {
            return 0;
        }

        for (int i =x/2+1; i>=0; i=i/2) {
            long result = 1L*i * i;
            if (result == x) {
                return i;
            }
            if (result > x) {
                return i - 1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }


}
