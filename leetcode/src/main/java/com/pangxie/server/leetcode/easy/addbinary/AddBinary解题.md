# LeetCode集锦（十六） - 第67题 Add Binary

## 问题

```
Given two binary strings, return their sum (also a binary string). 

 The input strings are both non-empty and contains only characters 1 or 0. 

 Example 1: 


Input: a = "11", b = "1"
Output: "100" 

 Example 2: 


Input: a = "1010", b = "1011"
Output: "10101" 


```
### 翻译:
> 给定两个二进制字符串，返回它们的和(也是一个二进制字符串)。
> 输入字符串都是非空的，并且只包含字符1或0。
> 示例1:
> 输入:a = "11"， b = "1"
> 输出:“100”
> 示例2:
> 输入:a = "1010"， b = "1011"
> 输出:“10101”
 
---
## 解题思路
本题是用字符串模拟2精制的加法，就按照逢2进1的方式遍历一遍，如果长度不同，则在把长的覆盖上去。

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
    if (a == null || b == null) {
            return a == null ? b : a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int add = 0;
        while (lenA >= 0 || lenB >= 0 || add > 0) {
            int result = (lenA >= 0 ? a.charAt(lenA) - '0' : 0) + (lenB >= 0 ? b.charAt(lenB) - '0' : 0) + add;
            add = result / 2;
            stringBuilder.append(result % 2);
            lenA--;
            lenB--;
        }

        return stringBuilder.reverse().toString();
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了没有使用额外空间，所以空间复杂度是O(n)=O(1);


## 总结
本题的大致解法如上所诉, 之前用StringBuilder的insert方法，发现速度很慢，看了下源码后，它都会移动数组，也就是正常的数组扩容拷贝，所以特别慢，再次就直接用append，然后反转一下，比之前方式要快很多。