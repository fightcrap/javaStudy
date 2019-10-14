# LeetCode 集锦（四十七） - 第 202 题 Happy Number

## 问题

```
Write an algorithm to determine if a number is "happy". 

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers. 

 Example: 


Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```

### 翻译:
>编写一个算法来确定一个数字是否“幸福”。  
>
>快乐的数量是一个数字定义为以下过程:从任何正整数,取代数的平方和的位数,并重复这个过程,直到数= 1(它将保持),或者它无休止地循环周期,不包括1。这个过程以1结束的那些数字是令人满意的数字。  
>
>例子:  
>
>输入:19  
>输出:真正的  
>解释:  
>12 + 92 = 82  
>82 + 22 = 68  
>62 + 82 = 100  
>12 + 02 + 02 = 1  

---

## 解题思路

本题是判断一个数是不是一个幸福数，而幸福数的定义是每位数的平分和，循环判断，直到为1，如果出现环来，那就不是幸福数了，这题不麻烦，按照描述编写记录就好了，只要判断有没有出现重复的数

## 解题方法

1. 一步步执行：

   ```
   public boolean isHappy(int n) {
           Set<Integer> set = new HashSet<>();
           while (n != 1) {
               set.add((int) n);
               long res = getNumber(n);
               if (res == 1) {
                   return true;
               }
               n = (int) res;
               if (set.contains(n)) {
                   return false;
               }
   
   
           }
           return true;
       }
   
       private long getNumber(int n) {
           int result = 0;
           while (n != 0) {
               int temp = n % 10;
               result += temp * temp;
               n = n / 10;
           }
           return result;
       }
   ```

   **时间复杂度**:
   该方案用中，时间复杂度不可计算记为O(n)=O(n)

   **空间复杂度**:
   该方案中使用map在存储循环的数，为O(n)=O(n)

## 总结

本题的大致解法如上所诉。

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
