# LeetCode集锦-medium（十六） - 第31题 Next Permutation

## 问题

```
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```
### 翻译:
>实现next permutation，它按照字典顺序将数字重新排列为下一个更大的数字排列。  
>如果这样的安排是不可能的，它必须重新安排它作为最低可能的顺序(即，按升序排序)。  
>替换必须在适当的位置，并且只使用固定的额外内存。  
>这里有一些例子。输入在左边一列，相应的输出在右边一列。  
>1、2、3→1 3 2  
>3、2、1→1 2 3  
>1、1、5→1 5 1  
---
## 解题思路
本题题意是让我们根据现有的数据，构成一个下一个大的数，使用数组来表示，我们其实只要找到后一位数比前一位数大，替换，就会比原始值大，但是不能保证是下一个值，那么我们是不是可以把后面的值进行排序一下，就可以确保是最小了，比如132，我们可以判断到1，3这边，1是要被替换到，但是是替换3嘛，很明显不是，我们要从后面在遍历一次
为什么呢？因为我们要的是比1略大的，我们会找到2（这边有个特点，根据第一步过滤，这边已经是降序排布了）所以是替换了2和1，这个时候需要把后面变为升序，会发现，后面那部分已经是降序了，所以直接前后兑换就好
## 解题方法
1. 按照题意方式
    ```
     public void nextPermutation(int[] nums) {
     
             int i = nums.length - 1;
             for (; i - 1 >= 0; i--) {
                 if (nums[i] > nums[i - 1]) {
                     break;
                 }
             }
     
             //转化一下
             if (i == 0) {
                 reverse(nums, 0, nums.length - 1);
             }
     
             for (int m = nums.length - 1; m >= i; m--) {
                 if (nums[m] >nums[i-1]) {
                     swap(nums, m, i-1);
                     reverse(nums,i,nums.length-1);
                     break;
                 }
             }
     
     
         }
     
     
         private void swap(int[] nums, int index, int index1) {
             nums[index] = nums[index] ^ nums[index1];
             nums[index1] = nums[index] ^ nums[index1];
             nums[index] = nums[index] ^ nums[index1];
         }
     
         private void reverse(int[] nums, int start, int end) {
             while (start < end) {
                 swap(nums, start, end);
                 start++;
                 end--;
             }
         }
    ```
    __时间复杂度__:
    该方案用了1层循环，相当于遍历，O(f(n))=O(n);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1


## 总结
本题的大致解法如上所诉,要注意一个特点，就是不是直接把后面那个大的值替换了，而是需要找恰好比那个值大的，还有一个就是替换后本身就是降序的了，直接反转就好了


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)