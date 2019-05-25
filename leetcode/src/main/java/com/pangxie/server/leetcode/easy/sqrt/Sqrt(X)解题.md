# LeetCode集锦（十七） - 第69题 Sqrt(X)

## 问题

```
Implement int sqrt(int x). 

 Compute and return the square root of x, where x is guaranteed to be a non-negative integer. 

 Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned. 

 Example 1: 


Input: 4
Output: 2


 Example 2: 


Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.

```
### 翻译:
> 实现int sqrt(int x)。
> 计算并返回x的平方根，其中x保证是一个非负整数。
> 由于返回类型是整数，因此将截断小数，只返回结果的整数部分。
> 示例1:
> 输入:4
> 输出:2
> 示例2:
> 输入:8
> 输出:2
> 说明:8的平方根是2.82842…,自
> 小数部分被截断，返回2。

---
## 解题思路
本题是找一个数是当前数的平方根，如果是小数，则返回舍弃小数的值。我们可以用遍历的方式，来判断是不是，当时这边需要考虑一下越界的问题，其实也可以不关注，毕竟可以得出越界的上限的平方根是多少，就可以避免这个问题。除了遍历，我们也可以用java自带的Math类来解决，是最简单的。除此之外，本题是找值，而且是在特定范围内找一个值，就可以想到是否可以用二分法来简短查询时间。

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
    if (x <= 0) {
            return 0;
        }

        for (int i =x/2+1; i>=0; i=i/2) {
            long result = 1L*i * i;
            if (result == x) {
                return i;
            }
            if (result > x) {
                return i - 1;
            }
        }
        return 0;
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n/2)=n;所以O(f(n))=O(n/2),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了没有使用额外空间，所以空间复杂度是O(n)=O(1);

2. 使用二分法，代码如下
    ```
    if (x <= 0) {
            return 0;
        }
        int start = 0;
        int end = x;
        while (start <= end) {
            int index = (start + end) / 2;
            long sum = 1L * index * index;
            if (sum > x) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return end;
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(logn)=n;所以O(f(n))=O(logn),即T(n)=O(logn)

    __空间复杂度__:
    该方案使用了没有使用额外空间，所以空间复杂度是O(n)=O(1);

2. 借用Math类，代码如下
    ```
     if (x <= 0) {
            return 0;
        }

        return (int)Math.sqrt(x);
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(1)=n;所以O(f(n))=O(1),即T(n)=O(1)

    __空间复杂度__:
    该方案使用了没有使用额外空间，所以空间复杂度是O(n)=O(1);

## 总结
本题的大致解法如上所诉, 在特地范围内，而且还是有序的，我们自然可以想到二分法来简化遍历，由于这题是需要最近的最小值，所以当end--后，大的值就变成来最小值，刚刚好满足。