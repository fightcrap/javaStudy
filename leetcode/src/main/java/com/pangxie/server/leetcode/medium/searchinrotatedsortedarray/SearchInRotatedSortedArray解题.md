# LeetCode集锦-medium（十七） - 第33题 Search in Rotated Sorted Array

## 问题

```
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```
### 翻译:
>假设一个按升序排序的数组在某个未知的主元处旋转。  
>(即。，[0,1,2,4,5,6,7]可以变成[4,5,6,7])。  
>给你一个要搜索的目标值。如果在数组中找到它的索引，则返回-1。  
>您可以假设数组中不存在副本。  
>您的算法的运行时复杂度必须在O(log n)的顺序。    
>示例1:  
>输入:nums = [4,5,6,7,0,1,2]， target = 0  
>输出:4  
>示例2:  
>输入:nums = [4,5,6,7,0,1,2]， target = 3  
>输出:1  
---
## 解题思路
本题题意是在一个伪有序数组中找一个数对应的下标，不存在就返回-1，为什么是伪呢？因为是局部有序，这个数组被旋转了，虽然我们可以旋转回来，但是需要返回原来的下标就没有用了，那么我们就可以用局部有序的方式来找这个数。
## 解题方法
1. 按照题意方式
    ```
     public void nextPermutation(int[] nums) {
     int start = 0;
             int end = nums.length - 1;
     
             while (start <= end) {
     
                 int index = (start + end) / 2;
                 if (nums[index] == target) {
                     return index;
                 }
                 if (nums[index] > nums[start]) {
                     if (nums[start] <= target && nums[index] >= target) {
                         end = index - 1;
                         continue;
                     }
                     if (nums[index] < target||nums[start]>target) {
                         start = index + 1;
                         continue;
                     }
     
                     end --;
     
                 }
     
                 if (nums[index] <= nums[start]) {
                     if (nums[end] < target) {
                         end = index - 1;
                         continue;
                     }
                     if (nums[end] > target&&nums[index]<=target) {
                         start =index+1;
                         continue;
                     }
                     start++;
     
                 }
             }
             return -1;
    ```
    __时间复杂度__:
    该方案用了1层循环，相当于遍历，O(f(n))=O(n);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1


## 总结
本题的大致解法如上所诉,感觉时间上并没有有logn，还是得想想其他的解决方式


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)