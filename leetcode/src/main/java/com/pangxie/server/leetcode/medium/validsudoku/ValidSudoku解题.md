# LeetCode集锦-medium（十九） - 第36题 Valid Sudoku

## 问题

```
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
```
### 翻译:
>给定一个按升序排序的整数数组，找出给定目标值的起始和结束位置。  
>您的算法的运行时复杂度必须在O(log n)的顺序。  
>如果在数组中没有找到目标，则返回[-1，-1]。  
>示例1:  
>输入:nums = [5,7,7,8,8,10]， target = 8  
>输出:(3、4)  
>示例2:  
>输入:nums = [5,7,7,8,8,10]， target = 6  
>输出:[1]  
---
## 解题思路
本题题意是在一个有序数组找出一个指定数的位置，但是数是有重复的，要返回最开始和最后相同数的下标，我们可以使用二分法找到数，然后循环往外扩张，找到最前和最后的下标，当然我们也可以用二分法来搜索。
## 解题方法
1. 按照循环往外扩展的方法
    ```
     int start = 0;
             int end = nums.length - 1;
             while (start <= end) {
     
                 int index = (start + end) / 2;
                 if (nums[index] == target) {
                     int first = index ;
                     int last = index ;
                     while (true) {
                         if (first-1 < 0 || nums[first - 1] != target) {
                             break;
                         }
                         first--;
                     }
     
                     while (true) {
                         if (last + 1 > nums.length - 1 || nums[last + 1] != target) {
                             break;
                         }
                         last++;
                     }
                     return new int[]{first, last};
                 }
     
                 if (nums[index] > target) {
                     end = index - 1;
                 }
                 if (nums[index] < target) {
                     start = index + 1;
                 }
             }
     
             return new int[]{-1,-1};
    ```
    __时间复杂度__:
    该方案用了用了二分法，相当于遍历，O(f(n))=O(logn);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1

2. 完全二分法
    ```
      public int[] searchRange(int[] nums, int target) {
     
             int index = dichotomySearch(nums, target, 0, nums.length - 1);
             if (index < 0) {
                 return new int[]{-1, -1};
             }
             //在根据二分来找前一个数；
             int first = index;
             int last = index;
             while (true) {
     
                 int temp = dichotomySearch(nums, target, 0, first - 1);
                 if (temp < 0) {
                     break;
                 }
                 first = temp;
             }
     
             while (true) {
     
                 int temp = dichotomySearch(nums, target, last + 1, nums.length - 1);
                 if (temp < 0) {
                     break;
                 }
                 last = temp;
             }
             return new int[]{first,last};
         }
     
         private int dichotomySearch(int[] nums, int target, int start, int end) {
     
             while (start <= end) {
     
                 int index = (start + end) / 2;
                 if (nums[index] == target) {
                     return index;
                 }
     
                 if (nums[index] > target) {
                     end = index - 1;
                 }
                 if (nums[index] < target) {
                     start = index + 1;
                 }
             }
             return -1;
         }

    ```
    __时间复杂度__:
    该方案用了用了二分法，相当于遍历，O(f(n))=O(logn);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1



## 总结
本题的大致解法如上所诉,正常的二分法查询方式，还是很简单的


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)