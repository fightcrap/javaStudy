# LeetCode 集锦（二十六） - 第 110 题 Balanced Binary Tree

## 问题

```
Given a binary tree, determine if it is height-balanced. 

 For this problem, a height-balanced binary tree is defined as: 

 a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 

 Example 1: 

 Given the following tree [3,9,20,null,null,15,7]: 

    3
   / \
  9  20
    /  \
   15   7 

 Return true. 
Example 2: 
 Given the following tree [1,2,2,3,3,null,null,4,4]: 

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

 Return false. 
```

### 翻译:
>给定一个二叉树，判断它是否高度平衡。
>对于该问题，定义高度平衡二叉树为:
>一种二叉树，其中每个节点的两个子树的深度相差不超过1。
>示例1:
>给定如下树[3,9,20,null,null,15,7]:
> ```
>    3
>   / \
>  9  20
>    /  \
>   15   7 
> ```
> 返回 true
>示例2:
>给定如下树[1,2,2,3,3,null,null,4,4]:
> ```
>       1
>      / \
>     2   2
>    / \
>   3   3
>  / \
> 4   4
> ```
> 返回 false
---

## 解题思路

本题是相对而言比较简单，判断一棵树是不是平衡二叉树。平衡二叉树的限制条件就是一个树的每个节点的左右子节点的深度相差不能超过1。按照这个思路，其实可以递归遍历出每个树节点的深度，判断左右节点是否差过1，就ok了

## 解题方法

1. 按照分治法

   ```
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
   ```

   **时间复杂度**:
   该方案用了遍历的方式，所以为O(n)=O(n)

   **空间复杂度**:
   该方案没有使用额外的空间，所以空间复杂度O(n)=O(1)


## 总结

本题的大致解法如上所诉，通过遍历的方式，来获取左右节点的高度，判断是否相差1，其实这边还可以优化，那就是获取高度的时候是不是0，如果不符合了就不需要在走下面的方式了。


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
