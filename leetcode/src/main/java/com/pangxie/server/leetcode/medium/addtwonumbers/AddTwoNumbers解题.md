# LeetCode集锦-medium（一） - 第2题 Add Two Numbers

## 问题

```
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:


Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

```
### 翻译:
>你有两个非空链表代表两个非负整数。这些数字以相反的顺序存储，每个节点包含一个数字。将这两个数字相加并以链表的形式返回。  
>您可以假设这两个数字不包含任何前导零，除了数字0本身。  
>例子:  
>输入:(2 -> 4 -> 3)+ (5 -> 6 -> 4)  
>输出:7 -> 0 -> 8  
>说明:342 + 465 = 807。  
 
---
## 解题思路
本题是基于链表的两数和，我们就按照正常的方式一个个位数相加就好

## 解题方法
1. 按照我们的思路来编辑，代码如下
    ```
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    
            ListNode listNode = new ListNode(0);
            ListNode head = listNode;
            int add = 0;
            while (l1 != null && l2 != null) {
    
                int sum = l1.val + l2.val + add;
    
                ListNode temp = new ListNode(sum % 10);
                add = sum / 10;
                head.next = temp;
                head = temp;
                l1 = l1.next;
                l2 = l2.next;
            }
    
            if (l1 != null) {
                head.next = l1;
    
            }
            if (l2 != null) {
                head.next = l2;
    
            }
            while (head.next != null && add != 0) {
                int temp = head.next.val + add;
                head.next.val = temp % 10;
                add = temp / 10;
                head = head.next;
            }
            if (add != 0) {
                ListNode listNode1 = new ListNode(add);
                head.next = listNode1;
            }
            return listNode.next;
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
    该方案用了循环n次,最多两者最大长度+1所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用了重新使用了链表，虽然最终复用了一部分（其实这样子是不对的），所以空间复杂度是O(n)=O(n);


## 总结
本题的大致解法如上所诉,本题解题不难，主要是要考虑全进位的问题


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)