# LeetCode集锦（九） - 第27题 Remove Element

## 问题

```
Given an array nums and a value val, remove all instances of that value in-place and return the new length. 

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory. 

 The order of elements can be changed. It doesn't matter what you leave beyond the new length. 

 Example 1: 


Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.


 Example 2: 


Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length. 

 Clarification: 

 Confused why the returned value is an integer but your answer is an array? 

 Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well. 

 Internally you can think of this: 


// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
} 

```
### 翻译:
> 给定数组号和值val，删除该值的所有实例并返回新的长度。  
> 不要为另一个数组分配额外的空间，您必须使用O(1)额外内存修改输入数组。  
> 元素的顺序可以改变。在新的长度之外留下什么并不重要。  
> 示例1:  
> 给定nums = [3,2,2,3]， val = 3，  
> 函数应该返回length = 2, nums的前两个元素为2。  
> 在返回长度之外留下什么并不重要。  
> 示例2:  
> 给定nums = [0,1,2,2,3,0,4,2]， val = 2，  
> 函数应该返回length = 5, nums的前五个元素包含0、1、3、0和4。  
> 注意，这五个元素的顺序可以是任意的。  
> 在返回长度之外设置什么值并不重要。  
> 澄清:  
> 为什么返回的值是整数而您的答案是数组?  
> 注意，输入数组是通过引用传入的，这意味着调用者也知道对输入数组的修改。  
> 你可以这样想:  
> // nums是通过引用传入的。(即。，无须复印)  
> int len = removeElement(nums, val);  
> //函数中对nums的任何修改都会被调用者知道。  
> //使用函数返回的长度，它输出第一个len元素。  
> for (int i = 0;i<len;i++){  
> print (num[i]);  
> }  



---
## 解题思路
本题思路很简单，该题和第26题很相似，这边是移除了指定的相同数字，而且本题对顺序没有要求，那么我们可以通过遍历，把相同的数据放到后面，返回非指定数字的数量就可以了

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
        int index = 0;
        int len = nums.length;
        for (int i = 0; i < len  - index; i++) {
            if (nums[i] != val) {
                continue;
            }

            int temp = len - 1 - index;
            nums[i] = nums[i] ^ nums[temp];
            nums[temp] = nums[temp] ^ nums[i];
            nums[i] = nums[temp] ^ nums[i];
            i--;
            index++;
        }

        return len - index;
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为1;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

## 总结
本题的大致解法如上所诉，本题本人无法想到优化的方式，只是利用了位运算来简化了换位的方式。