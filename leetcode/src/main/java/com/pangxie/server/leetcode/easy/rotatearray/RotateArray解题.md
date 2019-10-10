# LeetCode 集锦（四十三） - 第 189 题 Rotate Array

## 问题

```
Reverse bits of a given 32 bits unsigned integer. 



 Example 1: 


Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.


 Example 2: 


Input: 11111111111111111111111111111101
Output: 10111111111111111111111111111111
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001. 



 Note: 


 Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned. 
 In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825. 




 Follow up: 

 If this function is called many times, how would you optimize it? 

```

### 翻译:
>反转给定32位无符号整数的位。  
>示例1:  
>输入:00000010100101000001111010011100  
>输出:00111001011110000010100101000000  
>说明:输入二进制字符串00000010100101000001111010011100表示无符号整数43261596，返回964176192，其二进制表示为00111001011110000010100101000000。  
>示例2:  
>输入:11111111111111111111111111111101  
>输出:10111111111111111111111111111111  
>说明:输入的二进制字符串11111111111111111111111101表示无符号整数4294967293，因此返回3221225471，其二进制表示为10101111110010110010011101101001。  
>注意:  
>注意，在某些语言(如Java)中，不存在无符号整数类型。在这种情况下，输入和输出都将作为有符号整数类型给出，不应该影响您的实现，因为整数的内部二进制表示形式是相同的，无论它是有符号的还是无符号的。  
>在Java中，编译器使用2的补码表示法表示带符号的整数。因此，在上面的示例2中，输入表示有符号整数-3，输出表示有符号整数-1073741825。  

---

## 解题思路

本题是反转字节，属于位运算相关的题目，乍一看比较麻烦，其实可以换一个角度，翻转其实是左出，右近，目标数移除一位，新数补进这位，就可以达到翻转的效果

## 解题方法

1. 按照左进右出的方式：

   ```
   int result = 0;
           for(int i=0;i<Integer.SIZE;i++){
   
               result =( result << 1)+((n & 1) == 1?1:0);
               n = n >> 1;
           }
           return result;
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(32)=O(1)

   **空间复杂度**:
   该方案中没有使用额外的空间

## 总结

本题的大致解法如上所诉。这边遇到了一个坑，也就是int字节数长度，有些参数可能位数不足32位（前面全是0）导致一开始判断结束的时候缺少移动的位数，所以要指定32位。循环32次

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
