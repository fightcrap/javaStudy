# LeetCode集锦（四） - 第13题 Roman To Integer

## 问题

```
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M. 


Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000 

 For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II. 

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used: 


 I can be placed before V (5) and X (10) to make 4 and 9. 
 X can be placed before L (50) and C (100) to make 40 and 90. 
 C can be placed before D (500) and M (1000) to make 400 and 900. 


 Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999. 

 Example 1: 


Input: "III"
Output: 3 

 Example 2: 


Input: "IV"
Output: 4 

 Example 3: 


Input: "IX"
Output: 9 

 Example 4: 


Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.


 Example 5: 


Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 
```
### 翻译:
> 罗马数字由七种不同的符号表示:I、V、X、L、C、D和M。  
> 符号的值  
> I&emsp;&emsp;1  
> V&emsp;&emsp;5  
> X&emsp;&emsp;10  
> L&emsp;&emsp;50  
> C&emsp;&emsp;100  
> D&emsp;&emsp;500  
> M&emsp;&emsp;1000  
> 例如，2用罗马数字写成II，两个1相加。12写成，XII，就是X + II。27被写成XXVII，也就是XX + V + II。    
> 罗马数字通常从左到右由大到小书写。然而，4的数字不是IIII。4写成了4，因为1在5之前，所以减4。同样的原理也适用于数字9，也就是9。减法有六种应用:  
> 1. I可以把V(5)和X(10)放在前面，得到4和9。  
> 2. X可以放在L(50)和C(100)之前，得到40和90。  
> 3. C可以放在D(500)和M(1000)之前，得到400和900。
>  
> 给定一个罗马数字，把它转换成整数。输入保证在1到3999之间。  
> 示例1:  
> 输入:“III”  
> &emsp;&emsp;输出:3  
> 示例2:  
> &emsp;&emsp;输入:“IV”  
> 输出:4  
> &emsp;&emsp;示例3:  
> 输入:“IX”  
> &emsp;&emsp;输出:9  
> 示例4:  
> &emsp;&emsp;输入:“LVIII”  
> &emsp;&emsp;输出:58  
> &emsp;&emsp;说明:L = 50, V= 5, III = 3。  
> 例5:  
> &emsp;&emsp;输入:“MCMXCIV”  
> &emsp;&emsp;输出:1994  
> &emsp;&emsp;说明:M = 1000, CM = 900, XC = 90, IV = 4。  
---
## 解题思路
罗马数字的定义：[维基百科](https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97)  
在维基百科中，有条对我们本题解题很有帮助的一个规律，为：右加左减  
> 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。  
> 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。  

所以本题的思路就很清楚，我们从不遵从特性到遵从特性的情况逐步分析，可以分为3个思路:

思路一：直接按照字面来解决，我们可以先把罗马数字的含义记录到map，方便我们获取，包括特殊情况："IV"等这类,然后循环获取字符，如果是'I','X','C'我们就获取下一个字符，看看能否组合成特殊的情况，如果组合成功，则加上值，并下标移动，如果失败，加上本身的值。其他情况则加上本身的值就ok了。

思路二：该思路是对思路一的一种改进，我们知道特殊情况都是由前一个和当前这个组成（当然也可以是当前这个和后一个符号组合，相比是前后方便一点，因为思路一其实就是前后判断），所以我们主要记录前一个字符，和当前字符能否组合成特殊字符，如果能，减去前一字符两倍的值。最终都是加上当前的值。  

思路三：该思路是使用了上文提到的规律，如果左边的数小于右边的数，那么操作减法，相反则是加法。所以我们只需要判断前后大小，按照对应的计算方式，就可以算出值。


## 解题方法
1. 第一种解体方法，按照我们的思路来编辑，代码如下
    ```
    Map<String, Integer> map = new HashMap<>(16);
        map.put("I", 1);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            String temp = String.valueOf(c);
            if ((c == 'I' || c == 'X' || c == 'C') && (i + 1) < s.length()) {
                String m = String.valueOf(new char[]{c, s.charAt(i + 1)});
                if (map.get(m) != null) {
                    temp = m;
                    i++;
                }
            }
            result += map.get(temp);

        }
        return result;
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为一，所以记为n,所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了map存储罗马数值和阿拉伯数值的基本关系，是额外空间，不算空间复杂度，所以空间复杂度是O(1);

2. 第二种解题方法，代码如下:
    ```
     Map<String, Integer> map = new HashMap<>(7);
        map.put("I", 1);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        char last = s.charAt(0);
        int result = map.get(String.valueOf(last));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            String temp = String.valueOf(new char[]{last, c});
            Integer integer = map.get(temp);
            if (integer != null) {
                result = result - 2 * map.get(String.valueOf(last));
            }
            result += map.get(String.valueOf(c));
            last = c;
        }
        return result;
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为一，所以记为n,所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了map存储罗马数值和阿拉伯数值的基本关系，是额外空间，不算空间复杂度，所以空间复杂度是O(1);

3. 第三种解题方法，代码如下:
    ```
    Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char last = s.charAt(0);
        int result = map.get(last);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.get(last) < map.get(c)) {
                result = result - 2 * map.get(last);
            }
            result += map.get(c);
            last = c;
        }
        return result;

    ```
    __时间复杂度__:
    该方案用了循环，循环层数为一，所以记为n,所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了map存储罗马数值和阿拉伯数值的基本关系，是额外空间，不算空间复杂度，所以空间复杂度是O(1);

## 总结
本题的大致解法如上所诉，方案1和2因为要存储多余字符，所以只能用字符串类型存储，这就导致了后续字符都要转成字符串，出现了额外的开销，这个还是比较痛苦的，相对方案3就直接存储了字符，直接取就ok了。