# LeetCode集锦（十四） - 第58题 Length of Last Word

## 问题

```
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string. 

 If the last word does not exist, return 0. 

 Note: A word is defined as a character sequence consists of non-space characters only. 

 Example: 


Input: "Hello World"
Output: 5
```
### 翻译:
> 给定一个字符串s由大写/小写字母和空空格字符' '组成，返回字符串中最后一个单词的长度。  
> 如果最后一个单词不存在，返回0。  
> 注意:单词被定义为由非空格字符组成的字符序列。  
> 例子:
> 输入:“Hello World”
> 输出:5
> 给定整数数组号，找到具有最大和的相邻子数组(至少包含一个数字)并返回其和。  


---
## 解题思路
本题是很简单，我们只要遍历字符，统计不为空字符的字数，遇到空字符则重新计数，并记录上一次操作的数量，如果下一次为空串，则沿用上一次的结果。当然可以直接用string的方法来实现。

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
     if (s == null || "".equals(s)) {
            return 0;
        }
        int count = 0;
        int lastCount = count;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                lastCount = count == 0 ? lastCount : count;
                count = 0;
                continue;
            }
            count++;
        }
        return count == 0 ? lastCount : count;
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

2. 借用String的方法，代码如下
    ```
    if (s == null || "".equals(s)) {
            return 0;
        }
        s = s.trim();

        return s.length() - s.lastIndexOf(" ") - 1;
    
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

## 总结
本题的大致解法如上所诉,内容很简单，只要获取最后一个非空串的字符长度，特别要注意最后全是空字符的情况，那么是往前沿哦。