package com.pangxie.server.leetcode.easy.mergesortedarray;

/**
 * Create By fightingcrap On 2019/05/25
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
 * | MergeSortedArrayV1
 * |
 * | @author fightingcrap
 **/
public class MergeSortedArrayV1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //先把
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }

        //排序
        for (int i = 0; i < m + n; i++) {
            for (int j = i; j < m + n; j++) {
                if (nums1[i] > nums1[j]) {
                    nums1[i] = nums1[i] ^ nums1[j];
                    nums1[j] = nums1[j] ^ nums1[i];
                    nums1[i] = nums1[j] ^ nums1[i];
                }
            }
        }
    }
}
