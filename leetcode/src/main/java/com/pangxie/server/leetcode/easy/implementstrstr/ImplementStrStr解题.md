# LeetCode集锦（十） - 第28题 Implement StrStr

## 问题

```
Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:


Input: haystack = "hello", needle = "ll"
Output: 2


 Example 2:


Input: haystack = "aaaaa", needle = "bba"
Output: -1


 Clarification:

 What should we return when needle is an empty string? This is a great question to ask during an interview.

 For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


```
### 翻译:
> 实现strStr ()。  
> 返回haystack中needle的第一次出现的索引，如果针不是haystack的一部分，返回-1。  
> 示例1:  
> 输入:haystack = "hello"， needle = "ll"  
> 输出:2  
> 示例2:  
> 输入:haystack = "aaaaa"， needle = "bba"  
> 输出:1  
> 澄清:  
> 当needle是空字符串时，我们应该返回什么?这是一个非常适合在面试中问的问题。  
> 对于这个问题，当needle为空字符串时，我们将返回0。这与C的strstr()和Java的indexOf()一致。

---
## 解题思路
本题思路很简单，就是让我们实现java的indexof方法，我们根据循环判断haystack中是否有needle字符就行了，当然，可以直接调用java的api。

## 解题方法
1. 第一种解题方法，按照思路编辑，代码如下
    ```
     if (haystack == null || "".equals(needle)) {
            return 0;
        }
        int len = haystack.length() - needle.length()+1;
        int needLen = needle.length();
        for (int i = 0; i < len; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }
            int m;
            for (m = 1; m < needle.length(); m++) {
                if (haystack.charAt(i + m) != needle.charAt(m)) {
                    break;
                }
            }

            if (m == needLen) {
                return i;
            }
        }

        return -1;
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为2,所以O(f(n))=O(Mn),即T(n)=O(n^2)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

2. 第二种解题方法，直接调用api，简单粗暴(当然这个是不符合要求的），代码如下
    ```
    
        if (haystack == null ) {
            return 0;
        }

        return haystack.indexOf(needle);
    ```
    __时间复杂度__:
    该方案T(n)=O(1)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

## 总结
本题的大致解法如上所诉，本题只想到了一种方法，第二种方法是不符合要求的，偷懒专用，毕竟都选用了的语言，语言自带的不用白不用