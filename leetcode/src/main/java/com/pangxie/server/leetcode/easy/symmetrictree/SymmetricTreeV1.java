package com.pangxie.server.leetcode.easy.symmetrictree;

/**
 * Create By fightingcrap On 2019/06/08
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
 * | SymmetricTreeV1
 * |
 * | @author fightingcrap
 **/
public class SymmetricTreeV1 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);

    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        boolean isSame = left == null;
        isSame = isSame ? false : right != null && left.val == right.val;

        return isSame && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

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
