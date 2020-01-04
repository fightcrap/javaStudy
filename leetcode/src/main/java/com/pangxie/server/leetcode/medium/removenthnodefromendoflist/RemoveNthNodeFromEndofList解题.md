# LeetCode集锦-medium（十二） - 第19题 Remove Nth Node From End of List

## 问题

```
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
```
### 翻译:
>给定一个链表，从链表的末尾删除第n个节点并返回它的头。  
>例子:  
>给出链表:1->2->3->4->5,n = 2。  
>从末端删除第二个节点后，链表变为1->2->3->5。  
>注意:  
>给定n总是有效的。  
>跟进:   
>你能一次完成吗?  
---
## 解题思路
本题题意是移除倒数的第n个节点，我们有遇到的问题会有，链表长度不明确，如果用遍历计数的方式，也可以。但是就需要遍历两次。我们可以使用两个节点，遍历一次，当遍历的长度达到差值的时候，另一个节点就可以从头往下移，这样
就保证了两个节点差为n，当遍历到底的时候，另一个节点就是倒数第n个。然后移除就好。
## 解题方法
1. 按照题意方式
    ```
     if (head == null) {
                 return head;
             }
             ListNode temp = head;
             ListNode result = head;
             boolean isHeader = true;
             int tempIndex = 0;
             while (temp.next != null) {
                 if (tempIndex >= n) {
                     result = result.next;
                     isHeader = false;
                 }
                 tempIndex++;
                 temp = temp.next;
             }
     
             if (isHeader && tempIndex < n) {
                 head = head.next;
             } else {
                 result.next = result.next.next;
             }
     
     
             return head;
    ```
    __时间复杂度__:
    该方案用了1层循环，相当于遍历，O(f(n))=O(n);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1


## 总结
本题的大致解法如上所诉,我这边采用了前一个节点的计算，因为要移除节点，所以是需要前一个节点的值，用next来判断，就默认获取了前一个节点，但是需要注意的是头节点的替换


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)