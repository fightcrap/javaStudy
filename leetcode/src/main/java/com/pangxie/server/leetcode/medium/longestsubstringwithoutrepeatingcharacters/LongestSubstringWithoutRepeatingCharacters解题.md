# LeetCode集锦-medium（二） - 第3题 Longest Substring without repeating characters

## 问题

```
Given a string, find the length of the longest substring without repeating characters.


 Example 1:


Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.



 Example 2:


Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.



 Example 3:


Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

```
### 翻译:
>给定一个字符串，在不重复字符的情况下找出最长的子字符串的长度。   
>示例1:  
>输入:“abcabcbb”  
>输出:3  
>说明:答案是“abc”，长度为3。  
>示例2:  
>输入:“bbbbb”  
>输出:1  
>说明:答案是“b”，长度为1。  
>示例3:  
>输入:“pwwkew”  
>输出:3  
>说明:答案为“wke”，长度为3。  
>注意，答案必须是子字符串，“pwke”是子序列，而不是子字符串。  
 
---
## 解题思路
本题是找到两个重复字符中最长的子串，和之前找最大和的方式差不多，我们可以用一个模版记录字符串，遇到重复的就截取，对比最长的就好了.

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
    if (s == null || s.length() <= 0) {
                return 0;
            }
            String temp = "";
            String result = "";
            for (int i = 0; i < s.length(); i++) {
    
                char c = s.charAt(i);
                //如果在临时文件中存在，则获取
                if (temp.indexOf(c) != -1) {
                    //如果结果字段小，则两者替换
                    if (result.length() < temp.length()) {
                        result = temp;
                    }
                    temp = temp.substring(temp.indexOf(c)+1);
                }
                temp += c;
            }
    
            return Math.max(result.length(),temp.length());
    ```
    __时间复杂度__:
    该方案用了循环n次,所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了两个模版string，所以空间复杂度为O(1)


## 总结
本题的大致解法如上所诉,和最大和方式差不多


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)