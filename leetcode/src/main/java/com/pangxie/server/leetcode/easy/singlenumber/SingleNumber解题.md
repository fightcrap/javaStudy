# LeetCode 集锦（三十四） - 第 136 题 Single Number

## 问题

```
Given a non-empty array of integers, every element appears twice except for one. Find that single one. 

 Note: 

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 

 Example 1: 


Input: [2,2,1]
Output: 1


 Example 2: 


Input: [4,1,2,1,2]
Output: 4

```

### 翻译:
> 给定一个非空整数数组，除一个元素外，每个元素都出现两次。找到那一个。  
> 注意:  
> 您的算法应该具有线性运行时复杂度。你能在不使用额外内存的情况下实现它吗?  
> 示例1:  
> 输入(2 2 1):  
> 输出:1  
> 示例2:  
> 输入:[4、1、2、1、2)  
> 输出:4  
---

## 解题思路

本题是找出奇数位的那个值，这就让我们不由的想到了位运算 异或^操作，异或操作是位值相同则变成了0，不同则为1，所以如果是同一个数进行异或则会0，0和任何数异或都是当前值。所以很符合我们这边奇偶性筛选

## 解题方法

1. 使用异或方式来解体

   ```
    if (nums.length <= 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
   ```

   **时间复杂度**:
   该方案用了遍历的方式，所以为O(n)=O(n)

   **空间复杂度**:
   该方案没有使用额外的空间，所以空间复杂度O(n)=O(1)


## 总结

本题的大致解法如上所诉，使用位运算的特性，可以让本题更加简单，高效

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
