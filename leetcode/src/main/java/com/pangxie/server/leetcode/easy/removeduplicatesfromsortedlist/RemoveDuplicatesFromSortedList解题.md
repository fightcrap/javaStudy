# LeetCode集锦（十九） - 第83题 Remove Duplicates from sorted list

## 问题

```
Given a sorted linked list, delete all duplicates such that each element appear only once. 

 Example 1: 


Input: 1->1->2
Output: 1->2


 Example 2: 


Input: 1->1->2->3->3
Output: 1->2->3

```
### 翻译:
> 给定一个已排序的链表，删除所有重复项，使每个元素只出现一次。
> 示例1:
> 输入:1 - > 1 - > 2
> 输出:1 - > 2
> 示例2:
> 输入:1 - > 1 - > 2 - > 3 - > 3
> 输出:1 - > 2 - > 3
---
## 解题思路
本题思路很简单，由于链表是有序的，说明如果有重复的，肯定是下一个，按照顺序进行遍历，如果遇到当前节点和后一个节点相同，那么覆盖当前节点。遍历一次就搞定了

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode temp = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }
        return temp;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    ```
    __时间复杂度__:
    该方案用了循环m所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了没有使用额外空间，所以空间复杂度是O(n)=O(1);

## 总结
本题的大致解法如上所诉,本题大致只有一种解题方式，直接遍历读取覆盖即可，我是通过当前节点和下一个节点进行比较，也可以和前一个节点进行比较 。