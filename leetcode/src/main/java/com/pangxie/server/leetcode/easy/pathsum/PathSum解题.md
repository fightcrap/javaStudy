# LeetCode 集锦（二十八） - 第 112 题 Path Sum

## 问题

```
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. 

 Note: A leaf is a node with no children. 

 Example: 

 Given the below binary tree and sum = 22, 


      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1


 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. 
```

### 翻译:
>给定一棵二叉树和一个和，确定该树是否有根到叶的路径，以便将路径上的所有值相加等于给定的和。
>注意:叶子是没有子节点的节点。
>例子:
>给出下面的二叉树，sum = 22，
> ```
>      5
>     / \
>     4   8
>    /   / \
>   11  13  4
>  /  \      \
> 7    2      1
> ```
>返回 true, 由于存在根到叶的路径5->4->11->2，其和为22。
---

## 解题思路

本题相对而言也是简单的，求一个树的根节点到叶子节点的和为目标值。本题只要注意叶子节点就行：
1. 要是叶子节点，叶子节点指的是没有子节点的节点。如果只是一个节点为努力了，那样子不算叶子节点。
其他只要按照遍历的方式，判断是否复合要求
## 解题方法

1. 按照思路来编写结果

   ```
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
   ```

   **时间复杂度**:
   该方案用了遍历的方式，所以为O(n)=O(n)

   **空间复杂度**:
   该方案没有使用额外的空间，所以空间复杂度O(n)=O(1)


## 总结

本题的大致解法如上所诉，通过递归的方式来遍历每一个子节点，判断当前子节点的差是否满足要求，判断是否是叶子节点，就可以判断是否符合要求。


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
