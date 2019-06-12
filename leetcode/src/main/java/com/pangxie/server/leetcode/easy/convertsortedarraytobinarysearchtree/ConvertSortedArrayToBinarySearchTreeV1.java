package com.pangxie.server.leetcode.easy.convertsortedarraytobinarysearchtree;

/**
 * Create By fightingcrap On 2019/06/11
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
 * | ConvertSortedArrayToBinarySearchTreeV1
 * |
 * | @author fightingcrap
 **/
public class ConvertSortedArrayToBinarySearchTreeV1 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);


    }


    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right+1) / 2;
        TreeNode leftNode = sortedArrayToBST(nums, left, mid - 1);
        TreeNode rightNode = sortedArrayToBST(nums, mid + 1, right);
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = leftNode;
        treeNode.right = rightNode;
        return treeNode;

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
