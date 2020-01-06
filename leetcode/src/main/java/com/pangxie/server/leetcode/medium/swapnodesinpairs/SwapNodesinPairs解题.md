# LeetCode集锦-medium（十四） - 第24题 Swap Nodes in Pairs  

## 问题

```

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
```
### 翻译:
>给定一个链表，每两个相邻节点交换一次，并返回它的头。  
>您不能修改列表节点中的值，只能修改节点本身。  
>例子:  
>给出1->2->3->4，你应该返回列表为2->1->4->3。 
---
## 解题思路
本题题意是需要一对对的替换位置，由于是链表，所以我们要注意头节点的替换，因为是每一对替换，所以我们只要确定某一个节点存在next就可以进行替换。替换后的当前节点的下一个就是新的一对的开始。
## 解题方法
1. 按照题意方式
    ```
    
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode before = first;
        while (head!=null&&head.next != null) {
            ListNode next = head.next;
            before.next = next;
            head.next = next.next;
            next.next = head;
            before=head;
            head = head.next;
        }
        return first.next;
    ```
    __时间复杂度__:
    该方案用了1层循环，相当于遍历，O(f(n))=O(n);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1


## 总结
本题的大致解法如上所诉,根据一对对的特殊性，直接进行节点的替换就好了


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)