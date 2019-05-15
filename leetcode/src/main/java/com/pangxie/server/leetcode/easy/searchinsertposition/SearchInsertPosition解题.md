# LeetCode集锦（十一） -第35题 Search Insert Position

## 问题

```
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. 

 You may assume no duplicates in the array. 

 Example 1: 


Input: [1,3,5,6], 5
Output: 2


 Example 2: 


Input: [1,3,5,6], 2
Output: 1


 Example 3: 


Input: [1,3,5,6], 7
Output: 4


 Example 4: 


Input: [1,3,5,6], 0
Output: 0

```
### 翻译:
> 给定一个排序数组和一个目标值，如果找到目标，返回索引。如果没有，返回按顺序插入的索引所在的位置。  
> 您可以假定数组中没有重复项。  
> 示例1:  
> 输入:1、3、5、6,5  
> 输出:2  
> 示例2:  
> 输入:(1、3、5、6),2  
> 输出:1  
> 示例3:  
> 输入:1,3,5,6,7  
> 输出:4  
> 示例4:  
> 输入:(1、3、5、6),0  
> 输出:0  

---
## 解题思路

本题主要是为了找值，如果和目标值相等，就返回下标，如果没有找到，则返回离它最近且小于它的值的下标。本题可以用遍历解决，也可以使用二分法处理。

## 解题方法
1. 第一种解体方法，按照我们的思路来编辑，代码如下
    ```
        if (nums.length < 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    ```
    __时间复杂度__:
    该方案用了一层循环，循环度为n,即T(n)=O(n)

    __空间复杂度__:
    该方案并没有使用额外度空间去存储，所以空间复杂度还是O(1);

2. 第二种解题方法，是使用了二分查找的方式,代码如下:
    public int searchInsert(int[] nums, int target) {
        if (nums.length < 0) {
            return 0;
        }

        return serch(nums, 0, nums.length, target);

    }

    private int serch(int[] nums, int start, int end, int target) {

        if (start >= end) {
            return start;
        }

        int mod = (start + end) / 2;
        if (nums[mod] == target) {
            return mod;
        }
        if (nums[mod] < target) {
            return serch(nums, mod + 1, end, target);
        }

        if (nums[mod] > target) {
            return serch(nums, start, mod, target);
        }
        return 0;

    }
    ```
    __时间复杂度__:
    该方案用了递归二分查找，即T(n)=O(nlogn)

    __空间复杂度__:
    该方案并没有使用额外度空间去存储，所以空间复杂度还是O(1);
3. 第三种解题方案是针对与第二种解题优化的，递归查找在数据量足够大的情况下，性能略差，所以使用循环来解决递归。代码如下:
    ```
    if (nums.length < 0) {
            return 0;
        }
        int index = 0;
        int len = nums.length;
        while (index < len) {
            int mod = (index + len) / 2;
            if (nums[mod] == target) {
                return mod;
            } else if (nums[mod] > target) {
                len = mod;
            } else {
                index = mod + 1;
            }
        }

        return index;
    ```
    __时间复杂度__:
    该方案用了递归二分查找，即T(n)=O(nlogn)

    __空间复杂度__:
    该方案并没有使用额外度空间去存储，所以空间复杂度还是O(1);
## 总结
本题的大致解法如上所诉，但是可以更改的方式很多，运用循环，二分法来进行对本题的解答。