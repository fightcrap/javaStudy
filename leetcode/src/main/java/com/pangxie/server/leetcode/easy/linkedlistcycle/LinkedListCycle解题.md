# LeetCode 集锦（三十五） - 第 141 题 Linked List Cycle

## 问题

```
Given a linked list, determine if it has a cycle in it. 

 To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list. 




 Example 1: 


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.

 Example 2: 

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.

 Example 3: 

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

 Follow up: 

 Can you solve it using O(1) (i.e. constant) memory? 


```

### 翻译:
> 给定一个链表，判断它是否有一个循环。
> 为了在给定的链表中表示一个循环，我们使用一个整数pos，它表示tail连接到的链表中的位置(0索引)。如果pos为-1，则链表中没有循环。
> 示例1:
> 输入:head = [3,2,0，-4]， pos = 1
> 输出:true
> 说明:链表中有一个循环，tail连接到第二个节点。
> 示例2:
> 输入:head = [1,2]， pos = 0
> 输出:true
> 说明:链表中有一个循环，tail连接到第一个节点。
> 示例3:
> 输入:head = [1]， pos = -1
> 输出:false
> 说明:链表中没有循环。
> 跟进:
> 你能用O(1)(即常数)内存来解吗?

---

## 解题思路

本题是判断一个链表是否是环路，如果我们根据循环遍历，貌似是可以做到的，但是可能有个更加好的方式，在我们读取/遍历的时候把节点的value修改变成我们一个约束的条件，比如int的最小/最大值，如果再次读取到这个值，说明是循环了（当然这个方式是有一定危险的，因为。。。万一真的出现了一个节点的值和约定的特殊值相同，那就误判了）　

## 解题方法

1. 按照思路来编写结果

   ```
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        while (head != null) {
            if (head.val == Integer.MIN_VALUE) {
                return true;
            }
            head.val = Integer.MIN_VALUE;
            head = head.next;
        }
        return false;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
   ```

   **时间复杂度**:
   该方案用了遍历的方式，所以为O(n)=O(n)

   **空间复杂度**:
   该方案没有使用额外空间，所以空间复杂度O(n)=O(1)


## 总结

本题的大致解法如上所诉，抛开之前提到的问题，使用特殊值标记的情况下，改方案还是ok的

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
