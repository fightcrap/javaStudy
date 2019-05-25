# LeetCode集锦（十三） - 第53题 Maximum Subarray

## 问题

```
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum. 

 Example: 


Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.


 Follow up: 

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle. 


```
### 翻译:

> 给定整数数组号，找到具有最大和的相邻子数组(至少包含一个数字)并返回其和。  
> 例子:  
> 输入:[2,1,3、4、1、2、1、5、4],  
> 输出:6  
> 说明:[4，-1,2,1]的和最大= 6。   
> 跟进:  
> 如果您已经找到了O(n)的解决方案，那么尝试使用分治方法编写另一个解决方案，这种方法更加微妙。  


---
## 解题思路
本题是找寻最大值，我们第一想到的方式是遍历，一个个的加过去，判断出现的最大值是多少，当然这个不失为一种方式，但是换个角度想，加上正数肯定是越来越大的，加上负数是越来越小，如果加上一个负数，都比当前值要小了，那么就没有必要在加了，可以把累加值替换为当前值了，这样就不需要重头遍历判断了。所以按照这样子想，是否可以一次遍历就解决呢？

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
        if (nums.length < 1) {
            return 0;
        }

        int max = nums[0];
        int sum = max;
        for (int i = 1; i < nums.length; i++) {
            sum=sum + nums[i] < nums[i]?nums[i]:sum + nums[i];
            max=Math.max(sum,max);
        }
        return max;
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

## 总结
本题的大致解法如上所诉，本题只想到了一种方法，抛开遍历，只用了这一种方法，但是是否可以分治法来解决，貌似不太想得到。