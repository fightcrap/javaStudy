package com.pangxie.server.leetcode.easy.pathsum;

/**
 * Create By fightingcrap On 2019/06/18
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
 * | PathSumV1
 * |
 * | @author fightingcrap
 **/
public class PathSumV1 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (sum < 0 || root == null) {
            return false;
        }

        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);

        return left || right;

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
