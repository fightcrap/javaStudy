# LeetCode集锦（二十一） - 第100题 Same Tree

## 问题

```
Given two binary trees, write a function to check if they are the same or not. 

 Two binary trees are considered the same if they are structurally identical and the nodes have the same value. 

 Example 1: 


Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true


 Example 2: 


Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false


 Example 3: 


Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

```
### 翻译:
> 给定两棵二叉树，编写一个函数来检查它们是否相同。
> 如果两个二叉树在结构上是相同的，并且节点具有相同的值，则认为它们是相同的。
> 示例1:
> ```
>            1         1
>           / \       / \
>          2   3     2   3
>         [1,2,3],   [1,2,3]
>
>```
> 输出:true
>示例2:
> ```
>          1         1
>         /           \
>        2             2
>       [1,2],[1,null, 2)
>```
>输出:false
>示例3:
> ```
>           1         1
>          / \       / \
>         2   1     1   2
>        [1,2,1],   [1,1,2]
>```
>输出:false

---
## 解题思路
本题判断两个树是否相等，我们第一时间想到的就是遍历树节点，看看树节点是否一致（内容）。遍历树的方法有前序遍历，中序遍历，和后序遍历，这边选择了后序遍历。

## 解题方法
1. 后序遍历方式，代码如下
    ```
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right && p.val == q.val;
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
    __时间复杂度__:
    该方案用了递归遍历树，不要判断时间复杂度，而且树的遍历复杂度都说不好，且记为O(n)

    __空间复杂度__:
    该方案使用了没有使用额外空间，所以空间复杂度是O(n)=O(1);


## 总结
本题的大致解法如上所诉按照正常遍历树的方式来就好，选择自己喜欢的遍历方式，但是就是不会算树的时间复杂度。。。