# LeetCode 集锦（三十二） - 第 122 题 Best Time to Buy and Sell Stock II

## 问题

```
Say you have an array for which the ith element is the price of a given stock on day i. 

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times). 

 Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again). 

 Example 1: 


Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.


 Example 2: 


Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.


 Example 3: 


Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0. 

```

### 翻译:
> 假设你有一个数组，其中第i个元素是某只股票在第i天的价格。  
> 设计一个算法来寻找最大的利润。您可以完成任意数量的事务(即，买进一股，再卖出一股)。  
> 注:你不可同时进行多项交易(即，你必须先把股票卖了再买。  
> 示例1:  
> 输入:[7、1、5、3、6、4]  
> 输出:7  
> 说明:第2天买入(价格= 1)，第3天卖出(价格= 5)，利润= 5-1 = 4。  
> 然后第4天买进(价格= 3)，第5天卖出(价格= 6)，利润= 6-3 = 3。  
> 示例2:  
> 输入:(1、2、3、4、5)  
> 输出:4  
> 说明:第一天买入(价格= 1)，第5天卖出(价格= 5)，利润= 5-1 = 4。  
> 注意，你不能在第一天买，在第2天买，然后像现在这样卖  
> 同时处理多个事务。你必须先卖再买。  
> 示例3:  
> 输入:[7、6、4、3、1]  
> 输出:0  
> 说明:在本例中，没有进行任何交易，即最大利润= 0。  

---

## 解题思路

本题是上一题的升华版，由于我们知道如果当前值比之前定位的值大的话，卖出肯定是赚，同样如果定位到比目前最小值还小，那么就可以把前面最大的价格给加起来，这样子就代表之前购买的最大值已经购买，后续也是一样的。

## 解题方法

1. 按照思路来编写结果

   ```
    if(prices.length<=0){
            return 0;
        }
        int result = 0;
        int temp = prices[0];
        int index = 0;

        for (int i = 1; i < prices.length; i++) {

            index = Math.max(prices[i] - temp, index);
            if (prices[i] < prices[i - 1]) {
                result += index;
                temp = prices[i];
                index = 0;
            }
        }

        return result+index;

   ```

   **时间复杂度**:
   该方案用了一层遍历的方式，所以为O(n)=O(n)

   **空间复杂度**:
   该方案没有使用额外空间来存储，所以空间复杂度O(n)=O(1)


## 总结

本题的大致解法如上所诉，利用上一步的思路，把每一段的最大值都加起来，也就是利润最大的结果

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
