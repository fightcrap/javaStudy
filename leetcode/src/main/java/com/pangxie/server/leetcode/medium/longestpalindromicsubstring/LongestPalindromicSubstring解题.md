# LeetCode集锦-medium（三） - 第5题 Longest Palindromic Substring

## 问题

```
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000. 

 Example 1: 


Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.


 Example 2: 


Input: "cbbd"
Output: "bb"

```
### 翻译:
>给定一个字符串s，找出s中最长的回文子串。可以假设s的最大长度为1000。  
>示例1:  
>输入:“babad”  
>输出:“bab”  
>注意:“aba”也是一个有效的答案。  
>示例2:  
>输入:“cbbd”  
>输出:“bb”  
---
## 解题思路
本题是找到最长的子字符串为回文。这题做法思路就是优先查找重复字符串，然后判断两者是否为回文。注意一个字符就为回文哦

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
    public String longestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
    
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = i;
                while (true) {
                    int indexTemp = s.indexOf(c, index + 1);
    
                    if (indexTemp != -1) {
                        if(indexTemp-i<result.length()){
                            index=indexTemp;
                            continue;
                        }
                        String temp = s.substring(i, indexTemp + 1);
    
                        if (isPalindromic(temp) && temp.length() > result.length()) {
                            result = temp;
                        }
                        index = indexTemp ;
                    } else {
                        break;
                    }
                }
                if (result.length() == 0) {
                    result += c;
                }
            }
            return result;
        }
    
        private boolean isPalindromic(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    ```
    __时间复杂度__:
    该方案用了两层循环,所以O(f(n))=O(n^2),即T(n)=O(n^2)

    __空间复杂度__:
    该方案没有使用额外空间


## 总结
本题的大致解法如上所诉,总感觉有比较好的方式


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)