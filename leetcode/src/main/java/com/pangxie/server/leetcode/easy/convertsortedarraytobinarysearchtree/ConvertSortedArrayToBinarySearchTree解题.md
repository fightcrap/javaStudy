# LeetCode 集锦（二十五） - 第 108 题 Convert Sorted Array To Binary Search Tree

## 问题

```
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example:


Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5


```

### 翻译:
>给定一个按升序排列元素的数组，将其转换为高度平衡的BST。
>对于该问题，高度平衡二叉树定义为每个节点的两个子树深度相差不超过1的二叉树。
>例子:
>给定排序后的数组:[-10，-3,0,5,9]，
>一个可能的答案是:[0，-3,9，-10,null,5]，表示高度平衡BST:
> ```
>      0
>     / \
>   -3   9
>   /   /
> -10  5
> ```
---

## 解题思路

本题是相对而言比较复杂，需要一个高度平衡的二叉树，但是这边参数很特定，是一个排序的数组，排序的数组，变成高度平衡的二叉树，那不是只要对半折开就好了嘛，那不就是一颗树了嘛？

## 解题方法

1. 按照分治法

   ```
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
   ```

   **时间复杂度**:
   该方案用了二分法的方式，所以为O(n)=O(nlogn)

   **空间复杂度**:
   该方案没有使用额外的空间，所以空间复杂度O(n)=O(1)


## 总结

本题的大致解法如上所诉，根据二分法的方式，来解决对半拆分的情况。其实这边应该是有规律的，比如应该是和中间节点是有倍数关系的，但是具体我也没有去验证。


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
