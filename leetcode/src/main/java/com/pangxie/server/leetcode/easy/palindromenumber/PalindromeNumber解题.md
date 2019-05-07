# LeetCode集锦（三） - 第9题 Palindrome Number

## 问题

```
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward. 

 Example 1: 


Input: 121
Output: true


 Example 2: 


Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.


 Example 3: 


Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


 Follow up: 

 Coud you solve it without converting the integer to a string? 
```
### 翻译:
> 确定整数是否是回文。当一个整数向后读取与向前读取相同的内容时，它就是一个回文。
>
> 示例1:
>
> 输入:121
> 输出:真正的
>
> 示例2:
>
> 输入:-121
> 输出:假
> 说明:从左到右，是-121。从右到左，变成121-。因此它不是回文。
>
> 示例3:
>
> 输入:10
> 输出:假
> 说明:从右向左读取01。因此它不是回文。
>
> 跟进:
>
> 你能在不把整数转换成字符串的情况下解出它吗?

---
## 解题思路

本题目标是判断一个数字是不是回文数字。
> 回文数字的定义：翻转数字后，和本身一样则为回文数字。

根据回文数字的定义，负数是不符合要求的，毕竟符号的限制存在，个位数一定是回文数字。

在定义中，是需要翻转数字，判断前后是否一致，很容易想到可以转化为String，然后翻转一下，是否一致就可以。

还有一种方式，就是一位位的取，重新组装数字，判断是否一致，但是这样需要避免溢出的问题。


## 解题方法
1. 第一种解体方法，按照我们的思路来编辑，代码如下
    ```
     //负数直接不符合要求
        if (x < 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(x + "");
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    ```
    __时间复杂度__:
    该方案用了并没有使用循环，其实在翻转过程中应该是用来循环，但是这边不计算，所以f(n)=1=1;所以O(f(n))=O(1),即T(n)=O(1)

    __空间复杂度__:
    该方案使用了StringBuilder,相当于复刻了一个数组，所以空间复杂度是O(1);

2. 第二种解题方法，代码如下:
    ```
    //负数直接不符合要求
        if (x < 0) {
            return false;
        }
        int temp = x;
        long result = 0;
        while (temp != 0) {
            long remainder = temp % 10;
            result = result * 10 + remainder;
            temp /= 10;
        }
        return result == x;
    ```
    __时间复杂度__:
    该方案用了单层循环,所以f(n)=(log10(n)+1)/2=log10(n)/2;所以O(f(n))=O(log10(n))=O(log10(n)),即T(n)=O(log10(n))

    __空间复杂度__:
    该方案并没有使用额外的空间在存储数值，所以为O(1);

## 总结
本题的大致解法如上所诉，方案2没有利用到字符串，直接由本身出发，空间和时间上都比方案一快,唯一一点是需要用long来控制，避免越界。