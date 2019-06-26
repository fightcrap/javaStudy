# LeetCode 集锦（三十一） - 第 121 题 Best Time to Buy and Sell Stock

## 问题

```
Say you have an array for which the ith element is the price of a given stock on day i. 

 If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit. 

 Note that you cannot sell a stock before you buy one. 

 Example 1: 


Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.


 Example 2: 


Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

### 翻译:
> 假设你有一个数组，其中第i个元素是某只股票在第i天的价格。  
> 如你最多只获准完成一项交易(即，买一股，卖一股)，设计一个算法来寻找最大的利润。  
> 注意，你不能在买股票之前卖掉它。  
> 示例1:  
> 输入:[7、1、5、3、6、4]  
> 输出:5  
> 说明:第2天买入(价格= 1)，第5天卖出(价格= 6)，利润= 6-1 = 5。  
> 不是7-1 = 6，因为卖价需要大于买价。  
> 示例2:  
> 输入:[7、6、4、3、1]  
> 输出:0  
> 说明:在本例中，没有进行任何交易，即最大利润= 0。  
---

## 解题思路

本题是找寻一个买入卖出的最大理论，其实就是寻找当前值和后续值中相差最大的正数值。可以用循环遍历的方式查询，当然也可以一次循环，如果碰到比选中值更小的，那么就替换选中值，并选择差距最大的值记录，实现很简单

## 解题方法

1. 遍历方式，代码如下

   ```
     int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int m = i + 1; m < prices.length; m++) {
                result = Math.max(prices[m] - prices[i], result);
            }
        }

        return result;
   ```

   **时间复杂度**:
   该方案用了两次循环遍历的方式，所以为O(n)=O(n^2)

   **空间复杂度**:
   该方案没有使用额外的空间，所以空间复杂度O(n)=O(1)

2. 一次循环方式：

   ```
    if (prices.length <= 1) {
            return 0;
        }

        int temp = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {

            result = Math.max(prices[i] - temp, result);

            if (prices[i] < temp) {
                temp = prices[i];
            }
        }
        return result;
   ```

   **时间复杂度**:
   该方案用了一次遍历的方式，所以为O(n)=O(n)

   **空间复杂度**:
   该方案没有使用额外的空间，所以空间复杂度O(n)=O(1)

## 总结

本题的大致解法如上所诉，遍历虽然可以，但是性能不佳，可以定位比当前小的值，毕竟如果后面出现差值比较大的，小的值差值肯定更加大

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
