# LeetCode 集锦（二十七） - 第 111 题 Minimum Depth Of Binary Tree

## 问题

```
Given a binary tree, find its minimum depth. 

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node. 

 Note: A leaf is a node with no children. 

 Example: 

 Given binary tree [3,9,20,null,null,15,7], 


    3
   / \
  9  20
    /  \
   15   7 

 return its minimum depth = 2. 

```

### 翻译:
>给定一个二叉树，求它的最小深度。  
>最小深度是从根节点到最近叶子节点的最短路径上的节点数。  
>注意:叶子是没有子节点的节点。  
>例子:  
>给定如下树[3,9,20,null,null,15,7]:
> ```
>    3
>   / \
>  9  20
>    /  \
>   15   7 
> ```
> 返回 最小深度:2
---

## 解题思路

本题相对而言也是简单的，求一颗树的最小高度，所以首先要注意最小高度的定义：最小深度是从根节点到最近叶子节点的最短路径上的节点数。这边需要注意几个点：
1. 要是叶子节点，叶子节点指的是没有子节点的节点。如果只是一个节点为努力了，那样子不算叶子节点。
2. 是最近的叶子节点。
其他其实按照最大深度的方式去执行，就可以做到了
## 解题方法

1. 按照思路来编写结果

   ```
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
   ```

   **时间复杂度**:
   该方案用了遍历的方式，所以为O(n)=O(n)

   **空间复杂度**:
   该方案没有使用额外的空间，所以空间复杂度O(n)=O(1)


## 总结

本题的大致解法如上所诉，通过递归的方式来获取每一个子节点的深度，判断是否有叶子节点，然后获取最小的深度。


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
