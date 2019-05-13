# LeetCode集锦（八） - 第26题 Remove Duplicates From Sorted Array

## 问题

```
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length. 

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory. 

 Example 1: 


Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length. 

 Example 2: 


Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.


 Clarification: 

 Confused why the returned value is an integer but your answer is an array? 

 Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well. 

 Internally you can think of this: 


// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
} 


```
### 翻译:

> 给定一个已排序的数组号，删除重复项，使每个元素只出现一次，并返回新的长度。  
> 不要为另一个数组分配额外的空间，您必须使用O(1)额外内存修改输入数组。  
> 示例1:  
> 给定nums = [1,1,2]，  
> 函数应该返回length = 2, nums的前两个元素分别为1和2。  
> 在返回长度之外留下什么并不重要。  
> 示例2:  
> 给定nums = [0,0,1,1,1,2,2,3,3,4]，  
> 函数应该返回length = 5, nums的前五个元素分别修改为0、1、2、3和4。  
> 在返回长度之外设置什么值并不重要。  
> 澄清:  
> 为什么返回的值是整数而您的答案是数组?  
> 注意，输入数组是通过引用传入的，这意味着调用者也知道对输入数组的修改。  
> 你可以这样想:  
> // nums是通过引用传入的。(即。，无须复印)  
> int len = removeduplicate (nums);  
> //函数中对nums的任何修改都会被调用者知道。  
> //使用函数返回的长度，它输出第一个len元素。  
> for (int i = 0;i<len;i++){  
> print (num[i]);  
> }  


---
## 解题思路
本题思路很简单，要求我们使用O(1)的空间，也就是我们只能在当前数组上操作，由题目可知，数组是排序的,所以只要遍历一次，把不重复的往前面放，那么最前面的就是我们需要的结果。

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
     if (nums.length <= 1) {
            return nums.length;
        }
        int number = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[number]) {
                number++;
                nums[number] = nums[i];
            }
        }

        return number + 1;
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为1，即T(n)=O(n)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

## 总结
本题的大致解法如上所诉，本题只想到了一种方法，直接按照思路编写