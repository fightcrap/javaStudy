# LeetCode集锦（十五） - 第69题 Plus One

## 问题

```
Given a non-empty array of digits representing a non-negative integer, plus one to the integer. 

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit. 

 You may assume the integer does not contain any leading zero, except the number 0 itself. 

 Example 1: 


Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.


 Example 2: 


Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

```
### 翻译:
> 给定一个非空的数字数组，表示一个非负整数，加上1的整数次方。
> 这些数字的存储方式是，最有效的数字位于列表的顶部，数组中的每个元素都包含一个数字。
> 您可以假设整数不包含任何前导零，除了数字0本身。
> 示例1:
> 输入:(1、2、3)
> 输出(1、2、4):
> 说明:数组表示整数123。
> 示例2:
> 输入:[4、3、2、1)
> 输出:[4、3、2、2]
> 说明:数组表示整数4321。
---
## 解题思路
本题是基于数组后面加1，一般没有什么问题，特别要注意一下如果进位是最大的怎么办，我这边用了额外的数组来扩容这一步操作，同步赋值，如果有进位，则用新的数组。

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
    if (digits.length < 1) {
            return digits;
        }
        int len = digits.length;

        int[] result = new int[len];
        int[] result1 = new int[len + 1];
        int add = 1;
        for (int i = len - 1; i >= 0; i--) {
            int temp = add + digits[i];
            add = temp / 10;
            result[i] = temp % 10;
            result1[i + 1] = result[i];
        }
        if (add != 0) {
            result1[0] = add;
            return result1;
        }
        return result;
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了两个额外数组，所以空间复杂度是O(2n+1)=O(n);


## 总结
本题的大致解法如上所诉, 我是用了新的数组来替换原来的数组，当然也可以在原来的数组上修改，这样空间会更加小一点。