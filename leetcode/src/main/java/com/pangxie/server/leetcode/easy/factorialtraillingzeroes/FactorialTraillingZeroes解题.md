# LeetCode 集锦（四十二） - 第 172 题 Factorial Trailing Zeroes

## 问题

```
Given an integer n, return the number of trailing zeroes in n!. 

 Example 1: 


Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero. 

 Example 2: 


Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero. 

 Note: Your solution should be in logarithmic time complexity. 

```

### 翻译:
>给定一个整数n，返回以n结尾的0的个数!  
>示例1:  
>输入:3  
>输出:0  
>解释:3 != 6，后面没有0。  
>示例2:  
>输入:5  
>输出:1  
>解释:5 != 120，最后一个0。  

---

## 解题思路

本题是判断末尾存在多少个0，我们知道只要有5后面就会出现0，所以我们只要判断5的个数，并且累加起来就是有多少个0了，因为有些数可能会存在多个5，比如25其实是两个5，难道
我们只要先获取5的个数，然后在除以5同样的方式判断就可以获取出最终的答案了

## 解题方法

1. 递归判断5的个数：

   ```
      return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(1)

   **空间复杂度**:
   该方案中没有使用额外的空间


## 总结

本题的大致解法如上所诉。通过尾数0的特殊性，转化求5的个数。

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
