package com.pangxie.server.leetcode.easy.houserobber;

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
 * | HouseRobber
 * |
 * | @author fightingcrap
 **/
public class HouseRobberV1 {
    public int rob(int[] nums) {
        int no = 0;
        int yes = 0;
        for (int n : nums) {
            int temp = no;
            no = Math.max(no, yes);
            yes = temp + n;
        }
        return Math.max(no, yes);
    }
}
