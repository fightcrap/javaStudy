# LeetCode集锦（十八） - 第70题 Climbing Stairs

## 问题

```
You are climbing a stair case. It takes n steps to reach to the top. 

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 

 Note: Given n will be a positive integer. 

 Example 1: 


Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps


 Example 2: 


Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```
### 翻译:
> 你正在爬楼梯。到达山顶需要n步。
> 每次你可以爬1或2级台阶。你可以用几种不同的方式爬到山顶?
> 注意:给定n是一个正整数。
> 示例1:
> 输入:2
> 输出:2
> 说明:爬到山顶有两种方法。
> 1. 1步+ 1步
> 2. 2步
> 示例2:
> 输入:3
> 输出:3
> 说明:爬到山顶有三种方法。
> 1. 1步+ 1步+ 1步
> 2. 1步+ 2步
> 3. 2步+ 1步


---
## 解题思路
本题要求很明确，就是根据目标阶梯，预测一下需要多少中1，2组合方式走完整个阶梯，粗看貌似很麻烦，用循环来弄不知道有多少情况，各种if，但是换个角度来看，如果我们倒着推理，比如最后一级只可能是1步上来或者是2步上来，这样子逆退，就找出来一种递归的方式，但是这种方法比较耗时间，没有通过，不知道对不对，所以换一种方式，我们试试正向思维，3级是2步和一步跨上去的，那是不是2+1？同样4级，也是由两步和一步跨上去的，也就是n(4)=n(2)+n(3),哎呦，好像斐波那契数列哦。类似的推理，其实我们可以猜测出规律n(n)=n(n-1)+n(n-1).所以本题就解决了

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
    if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了没有使用额外空间，所以空间复杂度是O(n)=O(1);

## 总结
本题的大致解法如上所诉, 可以通过逆推来发现特定的规律，直接想可能是个很大的问题，所以可以考虑换个思维。