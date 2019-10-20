# LeetCode 集锦（四十九） - 第 204 题 Count Primes

## 问题

```
Count the number of prime numbers less than a non-negative number, n. 

 Example: 


Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

```

### 翻译:
>数一数小于非负数n的素数的个数。  
>例子:  
>输入:10  
>输出:4  
>说明:有4个小于10的质数，它们是2、3、5、7。  

---

## 解题思路

本题是检索从1到n中存在多少个素数，当然可以一个个的判断，并统计，但是相对而言，比较耗时，那么有没有好一点的方式，我们知道素数是是除了本身和1以外不能被其他数整除，
那么我们可以反向，把一个数乘上去，所得到的数一定不是素数，同理，偶数一定不是素数，使用图表法，来记录被乘后得到数的状态（没法用位图法，有点难过）。

## 解题方法

1. 按照思路来：

   ```
   if (n < 3) {
               return 0;
           }
   
           int count = n / 2;
           boolean[] booleans = new boolean[n];
           for (int i = 3; i * i < n; i += 2) {
               if (booleans[i]) {
                   continue;
               }
               for (int j = i * i; j < n; j += 2 * i) {
                   if (!booleans[j]) {
                       count--;
                       booleans[j] = true;
                   }
   
   
               }
           }
           return count;
   ```

   **时间复杂度**:
   不会计算。。。

   **空间复杂度**:
   该方案中了数组标记，所以空间复杂度是O(n)

## 总结

本题的大致解法如上所诉。

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
