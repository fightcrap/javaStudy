package com.pangxie.server.leetcode.easy.binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Create By fightingcrap On 2019/06/10
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
 * | BinaryTreeLevelOrderTraversalV1
 * |
 * | @author fightingcrap
 **/
public class BinaryTreeLevelOrderTraversalV1 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new LinkedList<>();
        List<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        lists.add(list);
        putNode(root, queue);
        while (queue.size() > 0) {
            List<Integer> resultTmep = new ArrayList<>();
            List<TreeNode> temp = new LinkedList<>();
            for (TreeNode treeNode : queue) {
                resultTmep.add(treeNode.val);
                putNode(treeNode, temp);
            }
            queue = temp;
            lists.add(0,resultTmep);
        }
        return lists;


    }

    private void putNode(TreeNode treeNode, List<TreeNode> list) {

        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            list.add(treeNode.left);
        }
        if (treeNode.right != null) {
            list.add(treeNode.right);
        }
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
