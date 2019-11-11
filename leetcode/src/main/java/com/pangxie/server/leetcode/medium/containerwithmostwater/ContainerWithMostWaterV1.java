package com.pangxie.server.leetcode.medium.containerwithmostwater;

/**
 * Create By fightingcrap On 2019/11/11
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
 * | ContainerWithMostWaterV1
 * |
 * | @author fightingcrap
 **/
public class ContainerWithMostWaterV1 {

    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;

        int result = 0;
        while (start < end) {

            int length = end - start;
            if (height[start] < height[end]) {
                result = Math.max(result, length * height[start]);
                start++;
            } else {
                result = Math.max(result, length * height[end]);
                end--;
            }

        }

        return result;
    }
}
