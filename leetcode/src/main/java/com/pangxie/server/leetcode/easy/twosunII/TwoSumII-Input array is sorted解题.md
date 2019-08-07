# LeetCode 集锦（三十八） - 第 167 题 two sum II -input array is sorted

## 问题

```
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number. 

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 

 Note: 

 Your returned answers (both index1 and index2) are not zero-based. 
 You may assume that each input would have exactly one solution and you may not use the same element twice. 

 Example: 

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2. 

```

### 翻译:
>给定一个已经按升序排序的整数数组，找到两个数字，使它们加起来等于一个特定的目标数字。  
>函数twoSum应该返回这两个数字的索引，使它们之和等于目标，其中index1必须小于index2。  
>注意:  
>您返回的答案(index1和index2)都不是从零开始的。  
>您可以假设每个输入都只有一个解决方案，并且不能两次使用相同的元素。  
>例子:  
>输入:number = [2,7,11,15]， target = 9  
>输出:[1,2]  
>说明:2和7的和是9。因此index1 = 1, index2 = 2。  
---

## 解题思路

本题是两数和的另外一种形式，提供一个有序数组，和一个目标值，计算出数组中可以相加为目标值的数。我们可以用之前的方法，把数据放在map里面，然后就可以根据后面的数字来获取是否为和。但是，题目中说是有序的数组，那么是否可以使用有序的特点。我们可以从两头往内遍历，用头尾两数和与目标值比较，判断出下一步的操作。这样子可能更好一点

## 解题方法

1. 按照map的方式：

   ```
     Map<Integer, Integer> map = new HashMap<>(numbers.length);
        if (numbers.length <= 1) {
            return new int[]{};
        }

        for (int i = 0; i < numbers.length; i++) {
            int dex = target - numbers[i];
            Integer value = map.get(dex);
            if (value != null) {
                return new int[]{value+1, i+1};
            }
            map.put(numbers[i],i);
        }
        return new int[]{};
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(n)

   **空间复杂度**:
   该方案中使用了map作为额外的空间存储，所以O(n)=O(n)

2. 头尾遍历实现：

   ```
     if (numbers.length <= 1) {
            return new int[]{};
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int dex = target - numbers[start];
            if (dex < numbers[end]) {
                end--;
            }else if (dex == numbers[end]) {
                return new int[]{start + 1, end + 1};
            }else if(dex>numbers[end]){
                start++;
            }
        }
        return new int[]{};
   ```

   **时间复杂度**:
   该方案用中，使用了一次遍历，所以为O(n)=O(n)

   **空间复杂度**:
   无

## 总结

本题的大致解法如上所诉，由于有提供有序的条件，那么方式就很多咯。

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
