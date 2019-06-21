# LeetCode 集锦（二十九） - 第 118 题 Pascal Triangle

## 问题

```
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle. 


In Pascal's triangle, each number is the sum of the two numbers directly above it. 

 Example: 


Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

```

### 翻译:
> 给定一个非负整数numRows，生成Pascal三角形的第一个numRows。  
> 在帕斯卡三角形中，每个数都是它上面两个数的和。  
> 例子:  
> 输入:5  
> 输出:  
> ```
>[
>     [1],
>    [1,1],
>   [1,2,1],
>  [1,3,3,1],
> [1,4,6,4,1]
]
> ```
---

## 解题思路

本题是简单的杨辉三角模型，只要了解杨辉三角的特点，就可以很简单的解决这个问题，杨辉三角的特点是每一行的第一个和最后一个都是1，中间的数值是由上一层相邻的两个相加而成。假设当前行的第n位，那么n=上一层的n位+上一层的n-1位。
## 解题方法

1. 按照思路来编写结果

   ```
        List<List<Integer>> lists = new ArrayList<>();


        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add(1);
                    continue;
                }
                List<Integer> laster = lists.get(i - 1);
                int sum = laster.get(j - 1) + laster.get(j);
                list.add(sum);
            }
            lists.add(list);

        }
        return lists;
   ```

   **时间复杂度**:
   该方案用了遍历的方式,两层嵌套循环，所以为O(n)=O(n^2)

   **空间复杂度**:
   该方案为了存储每一层数据，都用了list，所以空间复杂度O(n)=O(n^2)


## 总结

本题的大致解法如上所诉，杨辉三角还是很常见的，也是很简单的题，只要知道规律就不难


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
