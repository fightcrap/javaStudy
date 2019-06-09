package com.pangxie.server.leetcode.easy.maximumdepthofbinary;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Create By fightingcrap On 2019/06/09
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
 * | MaximumDepthOfBinaryV1
 * |
 * | @author fightingcrap
 **/
public class MaximumDepthOfBinaryV1 {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int result = 1;
        //定义一个队列
        List<TreeNode> list = new LinkedList<>();
        putNode(root, list);
        while (list.size() > 0) {
            //通过遍历的方式把队列里面的数据获取，并把左右子节点塞入
            int size = list.size();
            while (--size >= 0) {
                TreeNode treeNode = list.get(size);
                putNode(treeNode, list);
                list.remove(size);
            }
            result++;
        }
        return result;

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
