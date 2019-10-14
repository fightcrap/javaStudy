# LeetCode 集锦（四十六） - 第 198 题 House Robber

## 问题

```
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night. 

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police. 

 Example 1: 


Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4. 

 Example 2: 


Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.

```

### 翻译:
>你是一个专业的强盗，计划去抢劫街道上的房子。每家都有一定数量的钱被藏起来，阻止你抢劫他们的唯一限制是相邻的房子都有安全系统连接，如果两个相邻的房子在同一天晚上被闯入，它会自动联系警察。  
>
>给出一个非负整数的清单，代表每家的钱数，确定你今晚不报警就能抢劫的最大钱数。  
>
>示例1:  
>
>输入:(1、2、3、1)  
>输出:4  
>说明:抢劫1号房子(钱= 1)，然后抢劫3号房子(钱= 3)。  
>你可以抢劫的总数= 1 + 3 = 4。  
>
>示例2:  
>
>输入:[2、7、9、3、1]  
>输出:12  
>说明:抢劫1号房子(money = 2)，抢劫3号房子(money = 9)，抢劫5号房子(money = 1)。  
>你可以抢劫的总数= 2 + 9 + 1 = 12。  

---

## 解题思路

本题是求最大值，还记得之前做过的求最大和的情况，两者做法相同，不过这边需要间隔的获取，对我们而言
一个房子有两个状态，偷和不偷，根据两种情况来获取最大值，然后把不偷的情况加上偷的状态，那就是新的偷，而不偷的情况，一直是最大值，
根据错位，我们也可以解决间隔的问题

## 解题方法

1. 一步步执行：

   ```
   int no = 0;
           int yes = 0;
           for (int n : nums) {
               int temp = no;
               no = Math.max(no, yes);
               yes = temp + n;
           }
           return Math.max(no, yes);
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(n)=O(n)

   **空间复杂度**:
   该方案中没有使用额外的空间

## 总结

本题的大致解法如上所诉。本题略微有点不太好理解，可以多想想

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
