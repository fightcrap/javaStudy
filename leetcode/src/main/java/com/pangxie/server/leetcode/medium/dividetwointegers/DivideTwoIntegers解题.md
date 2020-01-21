# LeetCode集锦-medium（十五） - 第29题 Divide Two Integers

## 问题

```


Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
```
### 翻译:
>给定两个整数的被除数和除数，在不使用乘法、除法和余运算符的情况下对两个整数进行除法。  
>将被除数除以除数后返回商。  
>整数除法应该向零截断。  
>示例1:  
>输入:被除数= 10，除数= 3  
>输出:3  
>示例2:  
>输入:被除数= 7，除数= -3  
>输出:2  
>注意:  
>被除数和除数都是32位有符号整数。  
>除数永远不会是0。    
>假设我们处理的环境只能存储32位带符号整数范围内的整数:[−2^31,2^31−1]。对于这个问题，假设你的函数在除法结果溢出时返回231 - 1。  
---
## 解题思路
本题题意是让我们不用乘法和除法法，还有取模来计算除数，一看很麻烦，但是除了基础的加减乘除，我们可以使用的只有位运算了，位运算里面能使用除法的貌似也就左右移位了，但是左右移位是相对于2的倍数的，但是其实所有的数都是奇偶性的
我们都可以用2来表示。那么怎么和乘法挂钩呢？我们知道x*y=z==>x*(2^n+2^x...)=z的，所有我们可以用这个方式来解体
## 解题方法
1. 按照题意方式
    ```
     boolean isNotNegative = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
            if (divisor == 1 || divisor == -1) {
                if (dividend == Integer.MIN_VALUE && divisor == -1) {
                    return Integer.MAX_VALUE;
                }
                return dividend * divisor;
            }
            long temp = 0;
            long divisorTemp=0;
            if (dividend == Integer.MIN_VALUE) {
                temp = Integer.MAX_VALUE + 1L;
            } else {
                temp = Math.abs(dividend);
            }
    
            if (divisor == Integer.MIN_VALUE) {
                divisorTemp = Integer.MAX_VALUE + 1L;
            } else {
                divisorTemp = Math.abs(divisor);
            }
    
            int result = 0;
            while (temp >= divisorTemp) {
    
                int i=0;
                for (; i < 31; i++) {
    
                    long value = divisorTemp * 1L << i;
    
                    if (value > temp) {
                        temp = temp - (divisorTemp << (i - 1));
                        if (i - 1 == 0) {
                            result += 1;
                            break;
                        }
                        result += 1 << (i - 1);
                        break;
                    }
                }
                if(i==31){
                    temp=temp-Integer.MAX_VALUE;
                    result += 1 <<  30;
                }
    
            }
            return result * (isNotNegative ? 1 : -1);
    ```
    __时间复杂度__:
    该方案用了1层循环，相当于遍历，O(f(n))=O(n);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1


## 总结
本题的大致解法如上所诉,这题不是很复杂，但是主要是要处理溢出的问题，比较麻烦，垃圾题目


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)