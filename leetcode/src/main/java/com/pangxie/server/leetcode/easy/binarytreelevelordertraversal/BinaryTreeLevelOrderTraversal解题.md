# LeetCode 集锦（二十四） - 第 107 题 Binary Tree Level Order Traversal

## 问题

```
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root). 
For example: 
Given binary tree [3,9,20,null,null,15,7], 
    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as: 
[
  [15,7],
  [9,20],
  [3]
]
```

### 翻译:
>给定一个二叉树，返回其节点值的自底向上顺序遍历。(即从左到右，从叶到根，一层一层地)。


>例如:
>给定二叉树[3,9,20,null,null,15,7]，
> ```
>   3
>  / \
> 9  20
>   /  \
>  15   7 
> ```
> 返回自底向上的顺序遍历，如下:
>[
>  [15,7],
>  [9,20],
>  [3]
>]
---

## 解题思路

本题是倒叙输出一棵树的层次，哎呦，不就是层级遍历嘛，上一篇刚刚写过，至于倒序，那就是小问题了。咱们用linkedArrayList代替队列（虽然是由这个实现的，但是没有用到队列的特点。所以直接用了list，这边使用替换，代替了上次操作的remove，相对来说，效率会好一点

## 解题方法

1. 按照层级遍历的方式

   ```
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

   ```

   **时间复杂度**:
   该方案用了层级遍历的方式，时间复杂度相当于每一个的遍历，所以为O(n)=O(n)

   **空间复杂度**:
   该方案使用了额外的空间，使用了数组暂存树，相当于把树转化为了数组，所以空间复杂度O(n)=O(n)


## 总结

本题的大致解法如上所诉，相对于空间开销是差不多，效率提升不少，果然remove还是有点麻烦的。


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
