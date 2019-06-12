package com.pangxie.server.leetcode.easy.balancedbinarytree;

/**
 * Create By fightingcrap On 2019/06/12
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
 * | BalancedBinaryTreeV1
 * |
 * | @author fightingcrap
 **/
public class BalancedBinaryTreeV1 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return deap(root) != -1;

    }

    private int deap(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = deap(root.left) + 1;

        int right = deap(root.right) + 1;
        if (left == 0 || right == 0) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right);
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
