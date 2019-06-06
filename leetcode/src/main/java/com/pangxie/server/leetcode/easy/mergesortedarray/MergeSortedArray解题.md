# LeetCode集锦（二十） - 第88题 merge sorted array

## 问题

```
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array. 

 Note: 


 The number of elements initialized in nums1 and nums2 are m and n respectively. 
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 


 Example: 


Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

```
### 翻译:
> 给定两个排序整数数组nums1和nums2，将nums2合并为一个排序数组nums1。
> 注意:
> nums1和nums2中初始化的元素数量分别为m和n。
> 您可以假设nums1有足够的空间(大小大于或等于m + n)来容纳nums2中的其他元素。
> 例子:
> 输入:
> nums1 = [1,2,3,0,0,0]， m = 3
> nums2 = [2,5,6]， n = 3
> 输出:[1、2、2、3、5、6)

---
## 解题思路
本题是要合并两个数组，正常来说，我们可以新建一个数组来作为临时数组，把两个值都放进去，然后返回该数组，但是本题要在原数组上改，当然本题也可以这样子，新建一个临时数组，代替其中一个，在一个个遍历覆盖数组1，但是这样子就有多余都开销了。除了这个方法，我们也可以先把数组2添加到数组1中，然后进行排序，但是这样重复做了一次排序，如果是两个无序的，那么可以使用这种方式。那还有别的方式嘛？当然，我们习惯把小的放前面，那么是不是也可以把大的放后面呢？大的值肯定是按顺序放入，小的值还不能保证替换后的顺序，所以本题可以倒序遍历，把大的值往后放。

## 解题方法
1. 先合并两个数组，在排序的方式，代码如下
    ```
    //先把数组合并
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }

        //排序
        for (int i = 0; i < m + n; i++) {
            for (int j = i; j < m + n; j++) {
                if (nums1[i] > nums1[j]) {
                    nums1[i] = nums1[i] ^ nums1[j];
                    nums1[j] = nums1[j] ^ nums1[i];
                    nums1[i] = nums1[j] ^ nums1[i];
                }
            }
        }
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n^2)=n;所以O(f(n))=O(n^2),即T(n)=O(n^2)

    __空间复杂度__:
    该方案使用了没有使用额外空间，所以空间复杂度是O(n)=O(1);

2. 后序遍历，合并数组，代码如下
    ```
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m];
                m--;
            } else {
                nums1[m + n + 1] = nums2[n];
                n--;
            }
        }
        for(int i=0;i<=n;i++){
            nums1[i] = nums2[i];
        }
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n+m)=n;所以O(f(n))=O(m+n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了没有使用额外空间，所以空间复杂度是O(n)=O(1);


## 总结
本题的大致解法如上所诉,有时候按照正常的逻辑来，可能很复杂，但是换个角度，肯定就很简单了。