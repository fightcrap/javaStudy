package com.pangxie.server.leetcode.easy.countprimes;

/**
 * Create By fightingcrap On 2019/10/20
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
 * | CountPrimesaV1
 * |
 * | @author fightingcrap
 **/
public class CountPrimesaV1 {

    public int countPrimes(int n) {

        if (n < 3) {
            return 0;
        }

        int count = n / 2;
        boolean[] booleans = new boolean[n];
        for (int i = 3; i * i < n; i += 2) {
            if (booleans[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += 2 * i) {
                if (!booleans[j]) {
                    count--;
                    booleans[j] = true;
                }


            }
        }
        return count;
    }


}
