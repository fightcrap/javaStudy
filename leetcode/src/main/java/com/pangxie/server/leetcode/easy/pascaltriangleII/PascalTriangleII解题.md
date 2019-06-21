# LeetCode 集锦（三十） - 第 119 题 Pascal Triangle II

## 问题

```
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle. 

 Note that the row index starts from 0. 


In Pascal's triangle, each number is the sum of the two numbers directly above it. 

 Example: 


Input: 3
Output: [1,3,3,1]


 Follow up: 

 Could you optimize your algorithm to use only O(k) extra space? 
```

### 翻译:
> 给定一个k≤33的非负索引k，返回帕斯卡三角形的第k个索引行。
> 注意，行索引从0开始。
> 在帕斯卡三角形中，每个数都是它上面两个数的和。
> 例子:
> 输入:3
> 输出:[1,3,3,1]

---

## 解题思路

本题也是杨辉三角，但是和上一题的要求又是不一样的，这个只需要计算出当前行数所对应的值就行，规律和之前一样，所以直接执行即可，这边可以用一个数组完成，可以用倒序的方式，来一步步覆盖。

## 解题方法

1. 按照思路来编写结果

   ```
    if (rowIndex <= 0) {
            return Arrays.asList(1);
        }
        List<Integer> list = new ArrayList<>(rowIndex);

        for (int i = 1; i <= rowIndex+1; i++) {

            for (int j = i - 1; j >= 0; j--) {

                if(j == i - 1){
                    list.add(1);
                    continue;
                }
                if (j == 0  ) {
                    list.set(j, 1);
                    continue;
                }
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
   ```

   **时间复杂度**:
   该方案用了遍历的方式，所以为O(n)=O(n^2)

   **空间复杂度**:
   该方案使用了一个数组来存储结果，所以空间复杂度O(n)=O(n)


## 总结

本题的大致解法如上所诉，利用倒序的方式来避免了使用多余的空间，也算是一种方式把

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
