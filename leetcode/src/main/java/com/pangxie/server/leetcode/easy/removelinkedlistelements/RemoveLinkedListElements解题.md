# LeetCode 集锦（四十八） - 第 203 题 Remove Linked List Elements

## 问题

```
Remove all elements from a linked list of integers that have value val. 

 Example: 


Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5


```

### 翻译:
>从具有val值的整数的链表中删除所有元素。  
>例子:  
>
>输入:1->2->6->3->4->5->6,val = 6  
>输出:1 - > 2 - > 3 - > 4 - > 5

---

## 解题思路

本题是移除链表中，值相同的数，直接遍历就好了

## 解题方法

1. 一步步执行：

   ```
   public ListNode removeElements(ListNode head, int val) {
   
           ListNode listNode = head;
           ListNode temp = null;
           while (head != null) {
   
               if (head.val == val) {
                   if (temp != null) {
                       temp.next = head.next;
                   } else {
                       listNode = listNode.next;
                   }
                   head = head.next;
                   continue;
               }
               temp = head;
               head = head.next;
           }
           return listNode;
       }
   
   
       public class ListNode {
           int val;
           ListNode next;
   
           ListNode(int x) {
               val = x;
           }
       }
   ```

   **时间复杂度**:
   该方案用中循环n词，时间复杂度记为O(n)=O(n)

   **空间复杂度**:
   该方案中使用没有使用额外的空间

## 总结

本题的大致解法如上所诉。按照链表遍历的方式编写就好

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
