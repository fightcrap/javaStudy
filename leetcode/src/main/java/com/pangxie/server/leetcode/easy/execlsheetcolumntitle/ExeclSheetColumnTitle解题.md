# LeetCode 集锦（三十九） - 第 168 题 Execl Sheet Column Title

## 问题

```
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

 Example 1:

Input: 1
Output: "A"

 Example 2:

Input: 28
Output: "AB"

 Example 3:

Input: 701
Output: "ZY"
```

### 翻译:
>给定一个正整数，返回其对应的列标题，如Excel表中所示。
>例如:
1 - > A
2 - > B
3 - > C
…
26- > Z
27- > AA
28 - > AB
…
示例1:
输入:1
输出:“A”

示例2:
输入:28
输出:“AB”

示例3:
输入:701
输出:“ZY”
---

## 解题思路

本题相当于进制转化的一类型，把10进制转化为26位的大写字母进制，所以按照我们正常的进制操作就行了

## 解题方法

1. 按照思路：

   ```
      char normal = 'A';
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            n--;
            stringBuilder.insert(0,(char)(n % 26 + normal));
            n = n / 26;
        }

        return stringBuilder.toString();
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(n)

   **空间复杂度**:
   该方案中使用了String作为额外的空间存储，所以O(n)=O(1)

## 总结

本题的大致解法如上所诉，进制类的问题很多，但是解法都是一样的　。

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
