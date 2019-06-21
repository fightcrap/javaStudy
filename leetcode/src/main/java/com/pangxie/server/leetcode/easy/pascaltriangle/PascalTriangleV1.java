package com.pangxie.server.leetcode.easy.pascaltriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create By fightingcrap On 2019/06/20
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
 * | PascalTriangleV1
 * |
 * | @author fightingcrap
 **/
public class PascalTriangleV1 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();


        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                    continue;
                }
                List<Integer> laster = lists.get(i - 1);
                int sum = laster.get(j - 1) + laster.get(j);
                list.add(sum);
            }
            lists.add(list);

        }
        return lists;

    }
}
