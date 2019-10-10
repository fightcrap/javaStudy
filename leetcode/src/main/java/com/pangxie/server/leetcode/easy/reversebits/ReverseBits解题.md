# LeetCode 集锦（四十四） - 第 190 题 Reverse Bits

## 问题

```
Given an array, rotate the array to the right by k steps, where k is non-negative. 

 Example 1: 


Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]


 Example 2: 


Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


 Note: 


 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem. 
 Could you do it in-place with O(1) extra space? 

```

### 翻译:
>给定一个数组，将数组向右旋转k步，其中k是非负的。
>
>示例1:
>
>
>输入:[1,2,3,4,5,6,7]，k = 3  
>输出:(5、6、7、1、2、3、4)  
>解释:  
>向右旋转1步:[7,1,2,3,4,5,6]  
>向右旋转2步:[6,7,1,2,3,4,5]  
>向右旋转3步:[5,6,7,1,2,3,4]  
>
>
>示例2:  
>
>
>输入:[-1，-100,3,99]，k = 2  
>输出:(99,-100)  
>解释:  
>向右旋转1步:[99，-1，-100,3]  
>向右旋转2步:[3,99，-1，-100]  


---

## 解题思路

本题是按照指定位数进行向左移动，类似一个环状的数组，我们可以按照要求一步步的移动获得最后结果，也可以先把数组镜像翻折，这个时候的顺序相对而言是逆序的，如果我们
在指定点前段部分在做一次镜像，则前段数据的顺序会和之前一样，后段数据也同样，转化后就发现和移动的效果一致了

## 解题方法

1. 一步步执行：

   ```
   if (k == 0 || nums.length <= 0) {
               return;
           }
           k = k % nums.length;
           while (k > 0) {
               int length=nums.length;
               int temp = nums[length-1];
               for (int i = nums.length-1; i >0; i--) {
                   nums[i] = nums[i-1];
               }
               nums[0] = temp;
               k--;
           }
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(kn)=O(n)

   **空间复杂度**:
   该方案中没有使用额外的空间

2. 镜像法：

   ```
   public void rotate(int[] nums, int k) {
   
           if (k == 0 || nums.length <= 0) {
               return;
           }
           k = k % nums.length;
           rotate(nums, 0, nums.length - 1);
           rotate(nums, 0, k - 1);
           rotate(nums, k, nums.length - 1);
       }
   
       private void rotate(int[] nums, int start, int end) {
           while (start < end) {
               nums[start] = nums[start] ^ nums[end];
               nums[end] = nums[start] ^ nums[end];
               nums[start] = nums[start] ^ nums[end];
               start++;
               end--;
           }
       }
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(n)

   **空间复杂度**:
   该方案中没有使用额外的空间
## 总结

本题的大致解法如上所诉。根据镜像逆转，可以很有效的还原原来的顺序，也就可以达到移动的效果

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
