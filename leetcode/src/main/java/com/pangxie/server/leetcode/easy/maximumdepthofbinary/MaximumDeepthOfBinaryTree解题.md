# LeetCode 集锦（二十三） - 第 104 题 Maximum Depth of  Binary Tree

## 问题

```
Given a binary tree, find its maximum depth. 

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node. 

 Note: A leaf is a node with no children. 

 Example: 

 Given binary tree [3,9,20,null,null,15,7], 

    3
   / \
  9  20
    /  \
   15   7 

 return its depth = 3. 

```

### 翻译:

>给定一个二叉树，求它的最大深度。
>最大深度是从根节点到最远叶节点的最长路径上的节点数。
>注意:叶子是没有子节点的节点。
>例子:
>给定二叉树[3,9,20,null,null,15,7]，
> ```
>   3
>  / \
> 9  20
>   /  \
>  15   7 
> ```
>  返回结果是3


---

## 解题思路

本题是获取一棵树的深度，一般设计到树到题还是有点麻烦到，第一步想到算深度？是否可以按层级遍历，不就知道有多少层了嘛。这是一种方式，但是换一个角度想，一棵树的深度，不就是由它的左右节点决定的嘛，如果有左右节点就加一，同理，左右节点的深度又是由它们的子左右节点决定的，选择大的那个深度值，貌似就可以解决此题了

## 解题方法

1. 按照层级遍历的方式

   ```
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

    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;

       TreeNode(int x) {
           val = x;
       }
    }

   ```

   **时间复杂度**:
   该方案用了层级遍历的方式，时间复杂度相当于每一个的遍历，所以为O(n)=O(n)

   **空间复杂度**:
   该方案使用了额外的空间，使用了数组暂存树，相当于把树转化为了数组，所以空间复杂度O(n)=O(n)

2. 递归分治法：

   ```
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
   ```

   **时间复杂度**:
   该方案用了递归遍历的方式，时间复杂度相当于每一个的遍历，所以为O(n)=O(n)

   **空间复杂度**:
   该方案没有使用额外的空间，所以空间复杂度O(n)=O(1)

## 总结

本题的大致解法如上所诉，按层级遍历其实效果不怎么理想，个人估计是remove的操作导致的，如果可以不删除，直接数组代替树，效果可能会好一点。


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
