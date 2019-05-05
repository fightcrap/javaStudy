# LeetCode集锦（一） - two sum

## 问题

```
Given an array of integers, return indices of the two numbers such that they add up to a specific target. 

 You may assume that each input would have exactly one solution, and you may not use the same element twice. 

 Example: 


Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

```
### 翻译:
> 给定一个整数数组，返回两个数字的索引，使它们加起来等于一个特定的目标。
>
> 您可以假设每个输入都只有一个解决方案，并且不能两次使用相同的元素。
> 
> 给定数组:[2, 7, 11, 15] ,两数和为:9
> 
> 因为按顺序而言，2+7等于9，所以选择2和7对应的下标，0，1构成新数组。返回结果为[0,1]
---
## 解题思路

本题字面含义其实是求和，找寻两个数字的和为目标值，然后输出该两个数字的下标值。

换一个角度而言，我们这边有一个最终结果值--目标值，和一系列待选值--数组，如果我们在待选值中选择一个值，由目标值减去改值，就是另外需要寻找的值。这样我们就拿到全部需要的结果，需要做的只是从待选值中，查找那个差值。

## 解题方法
1. 第一种解体方法，按照我们的思路来编辑，代码如下
    ```
        for (int i = 0; i < nums.length; i++) {
            int differ = target - nums[i];

            for (int m = i + 1; m < nums.length; m++) {
                if (differ == nums[m]) {
                    return new int[]{i, m};
                }
            }
        }
        return new int[]{};
    ```
    __时间复杂度__:
    该方案用了两层嵌套循环，第一层循环度为n，第二层循环度也是n-m,所以f(n)=n*(n-m)=n^2-mn;所以O(f(n))=O(n^2),即T(n)=O(n^2)

    __空间复杂度__:
    该方案并没有使用额外度空间去存储，所以空间复杂度还是O(1);

2. 第二种解题方法，是延伸出来，既然我们要寻找另外一个值，是否可以用map这类数据结构来方便查询呢？代码如下:
    ```
        //先转化为hashmap
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            //如果是本身，就跳过
            if (integer != null && integer!=i) {
                return new int[]{i, integer};
            }
        }
        return new int[]{};
    ```
    __时间复杂度__:
    该方案用了单层循环，两次单层循环,所以f(n)=n+n=2n;所以O(f(n))=O(2n)=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了HashMap去存储数值和索引的关系，所以是原来数组的近似2倍（这边不考虑因为数据结构而导致的开销),即为2n,所以总共的空间复杂度为O(f(n))=O(3n)=O(n),所以空间复杂度还是O(n);
3. 第三种解题方案是针对与第二种解题优化的，第二种方案是直接把数组转化为map，所以这部分的空间开销是固定，如果我们可以一边读取，一边储存，那么是否可以更加简单呢？因为9-2=7，相对的9-7=2。所以按照这种思路，出现了第三种解题方案,代码如下:
    ```
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
       int differ = target - nums[i];
       Integer result = map.get(differ);
       if (null != result) {
          return new int[]{result,i };
       }
       map.put(nums[i], i);
    }
    return new int[]{};
    ```

## 总结
本题的大致解法如上所诉，但是可以更改的方式很多，如果输入的数组出现重复的情况，那么方法2是一个致命的错误解法，因为会把它覆盖，所以个人觉得，方法三是相对较优的一种解法。