# LeetCode集锦-medium（五） - 第8题 String to Integer

## 问题

```
Implement atoi which converts a string to an integer. 

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value. 

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function. 

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed. 

 If no valid conversion could be performed, a zero value is returned. 

 Note: 


 Only the space character ' ' is considered as whitespace character. 
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned. 


 Example 1: 


Input: "42"
Output: 42


 Example 2: 


Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.


 Example 3: 


Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.


 Example 4: 


Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed. 

 Example 5: 


Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned. 
```
### 翻译:
>实现将字符串转换为整数的方法。  
>该函数首先丢弃尽可能多的空白字符，直到找到第一个非空白字符。然后，从这个字符开始，取一个可选的初始加号或减号，后面跟尽可能多的数字，并将它们解释为一个数值。  
>字符串可以包含构成整数的字符之后的其他字符，这些字符将被忽略，并且对该函数的行为没有影响。  
>如果str中的第一个非空白字符序列不是有效的整数，或者由于str为空或它只包含空白字符而不存在这样的序列，则不执行转换。  
>如果不能执行有效的转换，则返回零值。  
>注意:  
>只有空格字符' '被认为是空白字符。  
>假设我们处理的环境只能存储32位带符号整数范围内的整数:[−231,231−1]。如果数值超出了可表示值的范围，则返回INT_MAX(231−1)或INT_MIN(−231)。  
>示例1:  
>输入:“42”  
>输出:42  
>示例2:  
>输入:“-42”  
>输出:-42  
>说明:第一个非空格字符是“-”，它是负号。  
>然后取尽可能多的数字，得到42。  
>示例3:  
>输入:“4193 with words”  
>输出:4193  
>说明:转换在数字“3”处停止，因为下一个字符不是数字。  
>示例4:  
>输入:“words and 987”  
>输出:0  
>说明:第一个非空白字符是“w”，它不是一个数字  
>数字或+/-号。因此，无法执行有效的转换。  
>例5:  
>输入:“-91283472332”  
>输出:-2147483648  
>说明:数字“-91283472332”超出了32位带符号整数的范围。  
>返回前INT_MIN(−231)。  
---
## 解题思路
本题是是数据转化题，按照它的要求来进行转化就好，没有很大的问题，本来想用正则提取，但是正则不适用这个场景

## 解题方法
1. 按照题意方式
    ```
     str = str.trim();
            if (str == null || str.length() <= 0) {
                return 0;
            }
            long result = 0;
            boolean isMinus = false;
            boolean isHasSpecial = false;
            boolean isStart = false;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '+' || c == '-') {
                    if (isStart || isHasSpecial) {
                        break;
                    }
                    isHasSpecial = true;
                    isMinus = c == '-';
                    continue;
                }
                isStart=true;
    
                if (c > '9' || c < '0') {
                    break;
                }
                result = result * 10 + c - '0';
                if (isMinus && result > Integer.MAX_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
    
    
            }
            return (int) ((isMinus ? -1 : 1) * result);
    ```
    __时间复杂度__:
    该方案用了1层循环，相当于遍历,所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案没有使用额外空间来存储字符串，O(f(n))=O(1),即T(n)=O(1)


## 总结
本题的大致解法如上所诉,看清楚题意，按照规则来编写，还是很简单的


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)