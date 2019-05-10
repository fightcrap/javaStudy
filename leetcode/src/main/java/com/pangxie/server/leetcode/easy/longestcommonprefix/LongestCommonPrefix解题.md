# LeetCode集锦（五） - 第14题 Longest Common Prefix

## 问题

```
Write a function to find the longest common prefix string amongst an array of strings. 

 If there is no common prefix, return an empty string "". 

 Example 1: 


Input: ["flower","flow","flight"]
Output: "fl"


 Example 2: 


Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


 Note: 

 All given inputs are in lowercase letters a-z. 

```
### 翻译:
> 编写一个函数来查找字符串数组中最长的公共前缀字符串。  
> 如果没有公共前缀，返回一个空字符串“”。  
> 示例1:  
> 输入:[“花”、“流”、“飞行”)  
> 输出:“fl”  
> 示例2:  
> 输入:“狗”,“赛车”,“车”)  
> 输出:”“  
> 说明:输入字符串之间没有公共前缀。  
> 注意:  
> 所有给定的输入都是小写字母a-z。  

---
## 解题思路
本题思路很简单，我们选定一个字符串（如果是最短的就最好了），然后根据循环，来一个个对比数组里面的字符串，一个个字符判断，来获取最短路径，找到符合条件的公共字符串，在和下一个比较，最终就是结果了

## 解题方法
1. 第一种解体方法，按照我们的思路来编辑，代码如下
    ```
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String st = strs[0];
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < st.length(); i++) {
            char s = st.charAt(i);
            for (int m = 1; m < strs.length; m++) {
                if (strs[m].length() <= i || strs[m].charAt(i) != s) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为2，由于第二层判断计数不好记，设为M,外层循环为n,所以f(n)=(n*M)=Mn;所以O(f(n))=O(Mn),即T(n)=O(Mn)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

## 总结
本题的大致解法如上所诉，本题只想到了一种方法，本来想优化查找的，使用二分法来查找，但是想到了二分法的应用场景：更多是用于定位，而不是圈定范围，所以就放弃了这个想法。