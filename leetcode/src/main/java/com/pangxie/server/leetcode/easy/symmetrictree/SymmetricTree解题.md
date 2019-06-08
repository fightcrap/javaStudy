# LeetCode 集锦（二十二） - 第 101 题 Symmetric Tree

## 问题

```
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3




 But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

 Note:
Bonus points if you could solve it both recursively and iteratively.
```

### 翻译:

> 给定一个二叉树，检查它是否是自身的镜像(即围绕其中心对称)。
> 例如，这个二叉树[1,2,2,3,4,4,3]是对称的:
>
> ```
>     1
>    / \
>   2   2
>  / \ / \
> 3  4 4  3
>
> ```
>
> 但是下面的[1,2,2,null,3,null,3]不是:
>
> ```
>    1
>   / \
>  2   2
>   \   \
>   3    3
> ```
>
> 注意:
> 如果你能递归地和迭代地解出它，那就更好了。

---

## 解题思路

本题判断两个树是否镜像树，镜像树的特点，在于它的左节点和右节点是一样的，根据这个特点我们可以解决这个问题。

## 解题方法

1. 按照思路代码如下

   ```
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
   该方案用了递归遍历树，不要判断时间复杂度，而且树的遍历复杂度都说不好，且记为 O(n)

   **空间复杂度**:
   该方案使用了没有使用额外空间，所以空间复杂度是 O(n)=O(1);

## 总结

本题的大致解法如上所诉，按照特点我们可以很简单的解决这个问题，其实也可以按层进行对比，判断每一层是否镜像，可以用队列来解决。


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
