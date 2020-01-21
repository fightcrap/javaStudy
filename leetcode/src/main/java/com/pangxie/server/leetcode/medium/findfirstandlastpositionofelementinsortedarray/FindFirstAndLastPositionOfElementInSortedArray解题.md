# LeetCode集锦-medium（十八） - 第34题 Find First and Last Position of Element in Sorted Array

## 问题

```
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```
### 翻译:
>给定一个按升序排序的整数数组，找出给定目标值的起始和结束位置。  
>您的算法的运行时复杂度必须在O(log n)的顺序。  
>如果在数组中没有找到目标，则返回[-1，-1]。  
>示例1:  
>输入:nums = [5,7,7,8,8,10]， target = 8  
>输出:(3、4)  
>示例2:  
>输入:nums = [5,7,7,8,8,10]， target = 6  
>输出:[1]  
---
## 解题思路
本题题意是在一个有序数组找出一个指定数的位置，但是数是有重复的，要返回最开始和最后相同数的下标，我们可以使用二分法找到数，然后循环往外扩张，找到最前和最后的下标，当然我们也可以用二分法来搜索。
## 解题方法
1. 按照循环往外扩展的方法
    ```
     int start = 0;
             int end = nums.length - 1;
             while (start <= end) {
     
                 int index = (start + end) / 2;
                 if (nums[index] == target) {
                     int first = index ;
                     int last = index ;
                     while (true) {
                         if (first-1 < 0 || nums[first - 1] != target) {
                             break;
                         }
                         first--;
                     }
     
                     while (true) {
                         if (last + 1 > nums.length - 1 || nums[last + 1] != target) {
                             break;
                         }
                         last++;
                     }
                     return new int[]{first, last};
                 }
     
                 if (nums[index] > target) {
                     end = index - 1;
                 }
                 if (nums[index] < target) {
                     start = index + 1;
                 }
             }
     
             return new int[]{-1,-1};
    ```
    __时间复杂度__:
    该方案用了用了二分法，相当于遍历，O(f(n))=O(logn);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1

2. 完全二分法
    ```
      public int[] searchRange(int[] nums, int target) {
     
             int index = dichotomySearch(nums, target, 0, nums.length - 1);
             if (index < 0) {
                 return new int[]{-1, -1};
             }
             //在根据二分来找前一个数；
             int first = index;
             int last = index;
             while (true) {
     
                 int temp = dichotomySearch(nums, target, 0, first - 1);
                 if (temp < 0) {
                     break;
                 }
                 first = temp;
             }
     
             while (true) {
     
                 int temp = dichotomySearch(nums, target, last + 1, nums.length - 1);
                 if (temp < 0) {
                     break;
                 }
                 last = temp;
             }
             return new int[]{first,last};
         }
     
         private int dichotomySearch(int[] nums, int target, int start, int end) {
     
             while (start <= end) {
     
                 int index = (start + end) / 2;
                 if (nums[index] == target) {
                     return index;
                 }
     
                 if (nums[index] > target) {
                     end = index - 1;
                 }
                 if (nums[index] < target) {
                     start = index + 1;
                 }
             }
             return -1;
         }

    ```
    __时间复杂度__:
    该方案用了用了二分法，相当于遍历，O(f(n))=O(logn);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1



## 总结
本题的大致解法如上所诉,正常的二分法查询方式，还是很简单的


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)