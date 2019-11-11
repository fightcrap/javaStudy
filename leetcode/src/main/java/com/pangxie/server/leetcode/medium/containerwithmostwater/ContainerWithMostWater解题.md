# LeetCode集锦-medium（六） - 第11题 Container With Most Water

## 问题

```
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.





 The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



 Example:


Input: [1,8,6,2,5,4,8,3,7]
Output: 49
```
### 翻译:
>给定n个非负整数a1 a2…，其中每个点表示坐标(i, ai)处的一个点。画出n条垂直线，使得直线i的两个端点在(i, ai)和(i, 0)处。找出两条直线，这两条直线和x轴构成一个容器，使得容器中含有最多的水。 
>注意:你不能倾斜容器，n至少是2。
>上述垂直线由数组[1,8,6,2,5,4,8,3,7]表示。在这种情况下，容器所能容纳的最大水面积(蓝色部分)是49。
>例子:
>输入:(1、8、6、2、5、4、8、3、7]
>输出:49  
---
## 解题思路
本题是求最大面积，由两个坐标到x轴构成的面积最大，我们可以循环遍历的方式，求出全部的面积，获取最大的，但是很明显这个方式太慢了，是否可以一次遍历就获取到呢？
答案是可以的，这边是获取最大面积，由于是漏桶，是取最小的，当我们移动的时候，长度会-1，所以只能变更高度来解决方式。我们可以从两侧开始遍历，如果遇到短的，就移动，搏一搏会不会变大。

## 解题方法
1. 按照题意方式
    ```
      int start = 0;
             int end = height.length - 1;
     
             int result = 0;
             while (start < end) {
     
                 int length = end - start;
                 if (height[start] < height[end]) {
                     result = Math.max(result, length * height[start]);
                     start++;
                 } else {
                     result = Math.max(result, length * height[end]);
                     end--;
                 }
     
             }
     
             return result;
    ```
    __时间复杂度__:
    该方案用了1层循环，相当于遍历,所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案没有使用额外空间来存储字符串，O(f(n))=O(1),即T(n)=O(1)


## 总结
本题的大致解法如上所诉,看清楚题意，按照规则来编写，还是很简单的


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)