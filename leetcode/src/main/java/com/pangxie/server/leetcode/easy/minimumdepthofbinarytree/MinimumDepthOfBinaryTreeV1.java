package com.pangxie.server.leetcode.easy.minimumdepthofbinarytree;

/**
 * Create By fightingcrap On 2019/06/17
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
 * | MinimumDepthOfBinaryTreeV1
 * |
 * | @author fightingcrap
 **/
public class MinimumDepthOfBinaryTreeV1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int right = minDepth(root.right) + 1;
        int left = minDepth(root.left) + 1;
        int min = Math.min(left, right);
        //判断是否有空的节点
        if (min <= 1) {
            return Math.max(right, left);
        }
        return min;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
