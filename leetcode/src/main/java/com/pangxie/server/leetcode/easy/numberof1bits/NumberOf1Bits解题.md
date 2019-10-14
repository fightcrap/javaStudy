# LeetCode 集锦（四十五） - 第 191 题 Number of 1 Bits

## 问题

```
Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight). 



 Example 1: 


Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.


 Example 2: 


Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.


 Example 3: 


Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits. 



 Note: 


 Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned. 
 In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3. 




 Follow up: 

 If this function is called many times, how would you optimize it? 


```

### 翻译:
>编写一个函数，该函数接受一个无符号整数并返回它所拥有的“1”位的数字(也称为汉明权值)。  
>
>示例1:  
>
>输入:00000000000000000000000000001011   
>输出:3  
>说明:输入二进制串00000000000000000000000000001011总共有三个“1”位。  
>
>示例2:  
>
>输入:00000000000000000000000010000000  
>输出:1  
>说明:输入二进制串00000000000000000000000010000000共有一个' 1 '。  
>
>示例3:  
>
>输入:11111111111111111111111111111101  
>输出:31  
>说明:输入的二进制字符串1111111111111111111111111101共有31个“1”位。  
>
>注意:  
>
>注意，在某些语言(如Java)中，不存在无符号整数类型。在这种情况下，输入将作为有符号整数类型给出，不应该影响您的实现，因为整数的内部二进制表示形式是相同的，无论它是有符号的还是无符号的。  
>在Java中，编译器使用2的补码表示法表示带符号的整数。因此，在上面的示例3中，输入表示带符号的整数-3。  
>跟进:  
>如果这个函数被多次调用，你将如何优化它?  

---

## 解题思路

本题是获取一个数的二进制数1的个数，可以用位运算，判断最后一位是不是1，然后右移，移除位数，最后就可以得到结果了

## 解题方法

1. 一步步执行：

   ```
    int result = 0;
           for (int i = 0; i < Integer.SIZE && n != 0; i++) {
               result += n & 1;
               n >>= 1;
           }
   
           return result;
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(32)=O(1)

   **空间复杂度**:
   该方案中没有使用额外的空间

## 总结

本题的大致解法如上所诉。根据位运算，可以很方便的计算出1的个数

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
