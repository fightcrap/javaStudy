# LeetCode集锦-medium（九） - 第16题 3Sum Closest

## 问题

```
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```
### 翻译:
>给定一个有n个整数的数组和一个整数目标，在nums中找到三个整数，使它们的和最接近目标。返回三个整数的和。你可以假设每个输入都有一个解。  
>   
>例子:  
>给定数组nums = [-1, 2, 1， -4]， target = 1。  
>最接近目标的和是2。(-1 + 2 + 1 = 2)    
---
## 解题思路
本题本题和三数和的考虑方式一样，只是这题不能只有用map来定位最后一位值，而是用遍历的方式来查找最相近的方法。
## 解题方法
1. 按照题意方式
    ```
     if (nums == null || nums.length < 3) {
                return 0;
            }
            Arrays.sort(nums);
            boolean isNegative = false;
            int temp = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int diffTemp = target - (nums[i] + nums[start] + nums[end]);
                    if (diffTemp > 0) {
                        start++;
                    }
                    if (diffTemp < 0) {
                        end--;
                    }
                    if (diffTemp == 0) {
                        return target;
                    }
                    if (Math.abs(diffTemp) < temp) {
                        temp = Math.abs(diffTemp);
                        isNegative = diffTemp < 0;
                    }
    
                }
            }
            return target - (isNegative ? -temp : temp);
    ```
    __时间复杂度__:
    该方案用了2层循环，相当于遍历,所以O(f(n))=O(n^2),即T(n)=O(n^2)

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1


## 总结
本题的大致解法如上所诉,做法和三数和相似，但是无法直接获取值。


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)