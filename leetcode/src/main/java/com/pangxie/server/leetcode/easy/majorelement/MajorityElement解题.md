# LeetCode 集锦（四十） - 第 169 题 Majority Element

## 问题

```
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. 

 You may assume that the array is non-empty and the majority element always exist in the array. 

 Example 1: 


Input: [3,2,3]
Output: 3 

 Example 2: 


Input: [2,2,1,1,1,2,2]
Output: 2
```

### 翻译:
>给定一个大小为n的数组，找到多数元素。大多数元素的元素⌊n / 2⌋多次出现。
>
>您可以假设数组是非空的，并且大多数元素始终存在于数组中。
>
>示例1:
>
>
>输入:[3、2、3)
>输出:3
>
>示例2:
>
>输入:[2 2 1,1,1,2,2]
>输出:2
---

## 解题思路

本题属于查找类题目，找出重复出现大于一半的数字，正常来说，我们可以用map来做计数，最后判断某一个值是否大于一半就行。但是是不是还有另外的方式，因为个数是大于一半的，如果说，来一个不一样的就消除个数，那么最终留下的那个，就会是超出一半的那个值。所以也可以用这种方式

## 解题方法

1. 使用map计数：

   ```
       int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        int mid = len / 2;
        for (int i = 0; i < len; i++) {
            int temp=nums[i];
            Integer value = map.get(temp);
            if (value == null) {
                value = 0;
            }
            value++;
            if (value > mid) {
                return temp;
            }
            map.put(temp, value );
        }
        return 0;
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(n)

   **空间复杂度**:
   该方案中使用了Map作为额外的空间存储，所以O(n)=O(n)

2. 使用消除方式：

   ```
        int result = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {

            if (len == 0) {
                result = nums[i];
                len = 1;
                continue;
            }
            if (result == nums[i]) {
                len++;
            } else {
                len--;
            }
        }
        return result;
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(n)

   **空间复杂度**:
   该方案中没有使用其他额外空间，所以O(n)=O(1)
## 总结

本题的大致解法如上所诉，查询类的题目还是相对简单一点，主要是效率和特点的判断。

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
