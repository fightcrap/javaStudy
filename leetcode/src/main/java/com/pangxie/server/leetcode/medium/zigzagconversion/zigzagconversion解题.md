# LeetCode集锦-medium（四） - 第6题 ZigZap Conversion

## 问题

```
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility) 


P   A   H   N
A P L S I I G
Y   I   R


 And then read line by line: "PAHNAPLSIIGYIR" 

 Write the code that will take a string and make this conversion given a number of rows: 


string convert(string s, int numRows); 

 Example 1: 


Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"


 Example 2: 


Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I 


```
### 翻译:
>字符串“PAYPALISHIRING”是在给定行数上以之字形书写的，如下所示:(您可能希望以固定字体显示此图案，以提高可读性)
>
>
>```
>    P     I    N
>    A   L S  I G
>    Y A   H R
>    P     I 
> ```
>然后一行一行地读:"PAHNAPLSIIGYIR"  
>编写代码，将采取一个字符串，并作出这种转换给定的行数:  
>字符串转换(字符串s, int numRows);   
>示例1:  
>输入:s = "PAYPALISHIRING"， numRows = 3  
>输出:“PAHNAPLSIIGYIR”  
>示例2:  
>输入:s = "PAYPALISHIRING"， numRows = 4  
>输出:“PINALSIGYAHRPI”  
>解释:  
>```
>P     I    N
>A   L S  I G
>Y A   H R
>P     I 
>```
---
## 解题思路
本题是图型题，我们可以按照要求来计算，构建一个数组，来存放每一列的数据，按照它的排列顺序，进行放置。还有一种方式是找规律。

## 解题方法
1. 按照数组方式
    ```
    if (numRows <= 1) {
                return s;
            }
    
            StringBuilder[] stringBuilders = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                stringBuilders[i] = new StringBuilder();
            }
    
            int i = 0;
            while (i < s.length()) {
                for (int j = 0; j < numRows && i < s.length(); j++) {
                    stringBuilders[j].append(s.charAt(i++));
                }
                for (int m = numRows - 2; m > 0 && i < s.length(); m--) {
                    stringBuilders[m].append(s.charAt(i++));
                }
    
            }
    
            for (int k = 1; k < numRows; k++) {
    
                stringBuilders[0].append(stringBuilders[k]);
            }
            return stringBuilders[0].toString();
    ```
    __时间复杂度__:
    该方案用了1层，相当于遍历,所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用额外空间来存储字符串，O(f(n))=O(n),即T(n)=O(n)

2. 找规律，2n-1，2n-2
    ```
    if(numRows<=1){
                return s;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
    
                int index = i;
                boolean isNext = false;
                int lastIndex = i;
                while (index < s.length() || (isNext && lastIndex + numRows * 2 - 2 < s.length())) {
                    if (index == i) {
                        stringBuilder.append(s.charAt(index));
                        index = index + 2 * numRows - 2 * (i == numRows - 1 ? 0 : i) - 2;
                        lastIndex = i;
                    } else {
                        if (isNext  ) {
                            if(i != 0 && i != numRows - 1){
                                stringBuilder.append(s.charAt(lastIndex + numRows * 2 - 2));
                            }
                            lastIndex = lastIndex + numRows * 2 - 2;
                            isNext = false;
                            continue;
                        }
                        stringBuilder.append(s.charAt(index));
    
                        index = index + numRows * 2 - 2;
                        isNext = true;
                    }
                }
    
            }
            return stringBuilder.toString();
    ```
    __时间复杂度__:
    该方案用了1层，相当于遍历,所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用额外空间来存储字符串，O(f(n))=O(n),即T(n)=O(n)


## 总结
本题的大致解法如上所诉,找规律比较痛苦


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)