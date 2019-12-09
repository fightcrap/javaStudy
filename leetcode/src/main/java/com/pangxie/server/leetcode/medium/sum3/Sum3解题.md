# LeetCode集锦-medium（八） - 第15题 Sum 3

## 问题

```
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```
### 翻译:
>给定一个有n个整数的数组，nums中是否有元素a、b、c使得a + b + c = 0?找出数组中所有唯一的三个一组，它们的和为0。  
> 注意:  
> 解决方案集不能包含重复的三元组。  
> 例子:  
> 给定数组nums = [-1, 0, 1, 2， -1， -4]，  
> 解集为:
> [
> [1,0,1],
> [1,1,2]
> ]   
---
## 解题思路
本题是是给定一个数，和数组，求出能和为指定数字的三个数字，乍一看，和我们之前做的2个数求和的方式差不多，但是这题有个麻烦点，就是不能重复，所以一般情况下我们需要先排个序。然后可以用两数和的方式，求出第三个数，毕竟减一减，就变成指定一个数，求两数和的问题了
## 解题方法
1. 按照题意方式
    ```
    if (nums.length < 3) {
                return new ArrayList<>();
            }
    
            Arrays.sort(nums);
            Set<List<Integer>> lists = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
    
                int number = nums[i];
                int sum = -number;
                int satrt = i + 1;
    
                int end = nums.length - 1;
                while (satrt < end) {
                    if (nums[satrt] + nums[end] == sum) {
                        lists.add(Arrays.asList(number, nums[satrt], nums[end]));
                        satrt++;
                        end--;
                    } else if (nums[satrt] + nums[end] < sum) {
                        satrt++;
                    } else {
                        end--;
                    }
                }
            }
            return new ArrayList<>(lists);
    ```
    __时间复杂度__:
    该方案用了2层循环，相当于遍历,所以O(f(n))=O(n^2),即T(n)=O(n^2)

    __空间复杂度__:
    该方案使用了map和list，O(f(n))=O(2n),即T(n)=O(n)


## 总结
本题的大致解法如上所诉,转化一下就变成我们之前所做的二数合了


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)