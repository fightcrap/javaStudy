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
 * | MergeSortedArrayV2
 * |
 * | @author fightingcrap
 **/
public class MergeSortedArrayV2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m];
                m--;
            } else {
                nums1[m + n + 1] = nums2[n];
                n--;
            }
        }
        for(int i=0;i<=n;i++){
            nums1[i] = nums2[i];
        }

    }
}
