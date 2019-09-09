# LeetCode 集锦（四十一） - 第 171 题 Excel Sheet Column Number

## 问题

```
Given a column title as appear in an Excel sheet, return its corresponding column number. 

 For example: 
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
 Example 1: 
Input: "A"
Output: 1

 Example 2: 

  Input: "AB"
  Output: 28

 Example 3: 
Input: "ZY"
Output: 701
```

### 翻译:
>给定Excel表中出现的列标题，返回对应的列号。  
>  
>例如:  
>A - > 1  
>B - > 2  
>C - > 3  
>…  
>Z - > 26  
>AA - > 27  
>AB - > 28  
>…  
>示例1:  
>输入:“”  
>输出:1  
>  
>示例2:  
>  
>输入:“AB”  
>输出:28  
>  
>示例3:  
>输入:“ZY”  
>输出:701  
---

## 解题思路

本题属于进制转化型，把字符转化为数字，按照要求来就行

## 解题方法

1. 使用map计数：

   ```
      if (s == null || s.length() < 1) {
            return 0;
        }
        int pagesize = 'Z' - 'A'+1;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int number = (s.charAt(i) - 'A' + 1);
            result = result * pagesize + number;
        }

        return result;
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(n)

   **空间复杂度**:
   该方案中没有使用额外的空间


## 总结

本题的大致解法如上所诉，进制转化类的问题比较简单，按照转化的规则来就行

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
