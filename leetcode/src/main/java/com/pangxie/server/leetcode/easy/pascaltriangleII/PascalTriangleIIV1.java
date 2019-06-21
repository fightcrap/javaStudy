package com.pangxie.server.leetcode.easy.pascaltriangleII;

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
 * | PascalTriangleIIV1
 * |
 * | @author fightingcrap
 **/
public class PascalTriangleIIV1 {
    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex <= 0) {
            return Arrays.asList(1);
        }
        List<Integer> list = new ArrayList<>(rowIndex);

        for (int i = 1; i <= rowIndex+1; i++) {

            for (int j = i - 1; j >= 0; j--) {

                if(j == i - 1){
                    list.add(1);
                    continue;
                }
                if (j == 0  ) {
                    list.set(j, 1);
                    continue;
                }
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;

    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
