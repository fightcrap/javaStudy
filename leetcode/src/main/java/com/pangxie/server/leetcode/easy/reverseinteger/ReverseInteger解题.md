# LeetCode集锦（二） - reverse integer

## 问题

```
Given a 32-bit signed integer, reverse digits of an integer. 

 Example 1: 


Input: 123
Output: 321


 Example 2: 


Input: -123
Output: -321


 Example 3: 


Input: 120
Output: 21


 Note: 
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows. 


```
### 翻译:
> 给定一个32位带符号整数，对其进行反数运算。
>
> 示例1:
>
> 输入:123
> 输出:321
>
> 示例2:
>
> 输入:-123
> 输出:-321
>
> 示例3:
>
> 输入:120
> 输出:21
>
> 注意:
> 假设我们处理的环境只能存储32位带符号整数范围内的整数:[- 231,231 - 1]。对于这个问题，假设函数在反向整数溢出时返回0。

---
## 解题思路

本题字面含义其实是对一个整数进行反转，这边需要注意三个点：
1. 带符号
2. 32位数字，反转后可能会溢出
3. 翻转后开头为0的要去掉。

思路一：我们可以利用String来进行直接的反转，对目标数先取绝对值，然后翻转，然后去掉头部为0的数字，并且反转完后把符号带上，如果大于Integer，则返回0，这边可以用long来代替，或者在转化integer的时候进行异常捕获

思路二：直接进行数字的翻转，先取绝对值，一个个位数获取下来，然后在拼接为最终结果，并除去头部为0的值，最后赋予富豪，用long来代替，比较integer的最大值。


## 解题方法
1. 第一种解体方法，按照我们的思路来编辑，代码如下
    ```
     //首先把0特殊去掉
        if (x == 0) {
            return 0;
        }
        //如果是负数，则变化成正数
        int temp = x;
        boolean isMinus = false;
        if (x < 0) {
            temp = -temp;
            isMinus = true;
        }
        //翻转,
        StringBuilder stringBuilder = new StringBuilder(temp+"").reverse();
        //除去前面的0
        int zoreCount = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '0') {
                zoreCount++;
            } else {
                break;

            }
        }
        if(zoreCount>0){
            stringBuilder.delete(0,zoreCount);
        }
        try{
            return Integer.valueOf(isMinus?"-"+stringBuilder.toString():stringBuilder.toString());
        }catch (Exception e){
            return 0;
        }
    ```
    __时间复杂度__:
    该方案用了并没有使用循环，其实在翻转过程中应该是用来循环，但是这边不计算，这边在判断头部为0的情况下，循环来一次，所以记为n,所以f(n)=((log10(n)-1)+0)/2=log10(n)/2;所以O(f(n))=O(log10(n)),即T(log10(n))=O(n)

    __空间复杂度__:
    该方案使用了StringBuilder,相当于复刻了一个数组，所以空间复杂度是O(1);

2. 第二种解题方法，代码如下:
    ```
     //如果是负数，则变化成正数
        long temp = x;
        boolean isMinus = false;
        if (x < 0) {
            temp = -temp;
            isMinus = true;
        }
        long value = 0;
        //获取长度。
        while (temp / 10 != 0 || temp % 10 != 0) {
            long remainder = temp % 10;

            value = value * 10 + remainder;
            if (value > Integer.MAX_VALUE) {
                return 0;
            }

            temp = temp / 10;
        }

        return (int) value * (isMinus ? -1 : 1);
    ```
    __时间复杂度__:
    该方案用了单层循环,所以f(n)=(log10(n)+1)/2=log10(n)/2;所以O(f(n))=O(log10(n))=O(log10(n)),即T(n)=O(log10(n))

    __空间复杂度__:
    该方案并没有使用额外的空间在存储数值，所以为O(1);

## 总结
本题的大致解法如上所诉，方案2没有利用到字符串，直接由本身出发，空间和时间上都比方案一快,唯一一点是需要用long来控制，万一int是负数最小值，一旦变成正数，就溢出了。