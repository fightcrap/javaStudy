# LeetCode集锦-medium（七） - 第12题 Integer To Roman

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


 Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999. 

 Example 1: 


Input: 3
Output: "III" 

 Example 2: 


Input: 4
Output: "IV" 

 Example 3: 


Input: 9
Output: "IX" 

 Example 4: 


Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.


 Example 5: 


Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 

```
### 翻译:
>罗马数字由七个不同的符号表示:I、V、X、L、C、D和M。  
>符号的值  
>I 1  
>V 5  
>X 10  
>L 50  
>C 100  
>D 500  
>M 1000  
>例如，2用罗马数字写成II，两个1相加。12被写成，XII，就是X + II。27这个数字被写成XXVII，也就是XX + V + II。  
>罗马数字通常是从左到右由大到小书写的。然而，数字4不是IIII。相反，数字4被写成IV，因为1在5之前，我们减去它，得到4。同样的原则也适用于数字9，即IX。有六种情况下使用减法:   
>I可以把V(5)和X(10)放在前面，得到4和9。  
>X可以放在L(50)和C(100)前面，得到40和90。  
>C可以放在D(500)和M(1000)之前，得到400和900。  
>给定一个整数，把它转换成罗马数字。输入保证在1到3999之间。  
>示例1:  
>输入:3  
>输出:“III”  
>示例2:  
>输入:4  
>输出:“IV”  
>示例3:  
>输入:9  
>输出:“IX”  
>示例4:  
>输入:58  
>输出:“LVIII”  
>说明:L = 50, V = 5, III = 3。  
>例5:  
>输入:1994  
>输出:“MCMXCIV”  
>说明:M = 1000, CM = 900, XC = 90, IV = 4。   
---
## 解题思路
本题是数据类型转化题，由于罗马数字组合比较特殊，就只有上述所列的情况，我们可以由大到小依次拼接，比如最大1000，先判断能不能减掉1000，如果可以，加上M，依次下去，知道为0；
## 解题方法
1. 按照题意方式
    ```
    
    private static Map<Integer, String> map = new HashMap<>();

    private static List<Integer> list = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");


    }

    public String intToRoman(int num) {

        int index = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int intValue = list.get(index);
            if (intValue > num) {
                index++;
                continue;
            }
            num = num - intValue;
            result.append(map.get(intValue));
        }
        return result.toString();
    }
    ```
    __时间复杂度__:
    该方案用了1层循环，相当于遍历,所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了map和list，O(f(n))=O(2n),即T(n)=O(n)


## 总结
本题的大致解法如上所诉,看清楚题意，按照规则来编写，还是很简单的


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)