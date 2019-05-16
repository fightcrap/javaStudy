# LeetCode集锦（十二） - 第38题 Count and Say

## 问题

```
The count-and-say sequence is the sequence of integers with the first five terms as following: 


1.     1
2.     11
3.     21
4.     1211
5.     111221


 1 is read off as "one 1" or 11. 
11 is read off as "two 1s" or 21. 
21 is read off as "one 2, then one 1" or 1211. 

 Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. 

 Note: Each term of the sequence of integers will be represented as a string. 



 Example 1: 


Input: 1
Output: "1"


 Example 2: 

Input: 4
Output: "1211" 
```
### 翻译:
> count-and-say序列是前五项为整数的序列:  
> 1     1  
> 2     11  
> 3      21  
> 4     1211  
> 5     111221    
> 1被读作“一个 1”或“11”。
> 11被读作“两个1”或21。
> 21被读作“1个2，然后1个1”或1211。  
> 给定一个整数n，其中1≤n≤30，生成count-and-say序列的第n项。  
> 注意:整数序列的每一项都表示为字符串。  
> 示例1:  
> 输入:1    
> 输出:“1”  
> 示例2:  
> 输入:4  
> 输出:“1211”  

---
## 解题思路
本题其实很简单，但是题目理解上可能不一样,本人一开始没有理解题意，看了下别人的解释才最终明白。本题主要是一个统计和说两个概念，按照我们正常习惯从左往右数和说，比如“1”，我们统计1的个数为1，所以count-and-say格式，第二层就是“11”，也就是一个1的意思，对应“11”而言，我们统计的1的个数为2，按照count-and-say格式，就是“21”，也就是第三层答案，2个1的意思。同理“21”，就是1个2，1个1，所以就是“1211”。本题的解题思路也是如此。

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
      String first = "1";
        if (n <= 1) {
            return first;
        }

        StringBuilder stringBuilder = new StringBuilder(first);
        for (int i = 1; i < n; i++) {
            StringBuilder stringBuilder1 = new StringBuilder();
            char pre = stringBuilder.charAt(0);
            int count = 1;
            for (int m = 1; m < stringBuilder.length(); m++) {
                if (stringBuilder.charAt(m) != pre) {
                    stringBuilder1.append(count).append(pre);
                    pre = stringBuilder.charAt(m);
                    count = 1;
                    continue;
                }
                count++;
            }
            stringBuilder1.append(count).append(pre);
            stringBuilder = stringBuilder1;

        }

        return stringBuilder.toString();
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为2，即T(n)=O(n^2)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

## 总结
本题的大致解法如上所诉，了解题意还是很重要的。