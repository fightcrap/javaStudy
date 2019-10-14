package com.pangxie.server.leetcode.easy.happynumber;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Create By fightingcrap On 2019/10/14
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
 * | HappyNumberV1
 * |
 * | @author fightingcrap
 **/
public class HappyNumberV1 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add((int) n);
            long res = getNumber(n);
            if (res == 1) {
                return true;
            }
            n = (int) res;
            if (set.contains(n)) {
                return false;
            }


        }
        return true;
    }

    private long getNumber(int n) {
        int result = 0;
        while (n != 0) {
            int temp = n % 10;
            result += temp * temp;
            n = n / 10;
        }
        return result;
    }

}
