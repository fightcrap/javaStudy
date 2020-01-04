# LeetCode集锦-medium（十一） - 第18题 4sum

## 问题

```
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```
### 翻译:
>给定一个包含n个整数的数组和一个整数目标，nums中是否有a、b、c和d元素使得a + b + c + d = target?找出数组中所有唯一的4个值，给出目标的和。  
>注意:  
>解决方案集不能包含重复的。  
>例子:    
>给定数组nums = [1,0， - 1,0， - 2,2]， target = 0。  
>解集为:  
> [  
> [- 1,0,0,1]，  
> [-2， -1, 1, 2]，  
> [- 2,0,0,2]  
> ]  
---
## 解题思路
本题题意是4数和，我们已经计算过了3数和2数和，计算4数和方法其实也就是在三数和外嵌套一层，就可以转化为3数和了，但是要注意不能重复
## 解题方法
1. 按照题意方式
    ```
     if (nums == null || nums.length < 4) {
                 return new ArrayList<>();
             }
     
             Arrays.sort(nums);
             Set<List<Integer>> set = new HashSet<>();
             for (int i = 0; i < nums.length - 3; i++) {
                 int diff = target - nums[i];
                 for (int j = i + 1; j < nums.length - 2; j++) {
                     int start = j + 1;
                     int end = nums.length - 1;
                     int diffTemp = diff - nums[j];
                     while (start < end) {
                         int sum = nums[start] + nums[end];
                         if (diffTemp == sum) {
                             set.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                             start++;
                             end--;
                         }
                         if (diffTemp < sum) {
                             end--;
                         }
                         if (diffTemp > sum) {
                             start++;
                         }
                     }
     
                 }
             }
             return new ArrayList<>(set);
    ```
    __时间复杂度__:
    该方案用了3层循环，相当于遍历，O(f(n))=O(n^3);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1


## 总结
本题的大致解法如上所诉,嵌套一层，就可以转化为3数和了


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)