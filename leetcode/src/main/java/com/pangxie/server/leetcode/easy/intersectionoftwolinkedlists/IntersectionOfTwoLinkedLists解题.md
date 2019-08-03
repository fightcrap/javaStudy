# LeetCode 集锦（三十七） - 第 160 题 Intersection of two linked lists

## 问题

```
Write a program to find the node at which the intersection of two singly linked lists begins. 

 For example, the following two linked lists: 
 begin to intersect at node c1. 
 Example 1: 

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B. 

 Example 2: 

Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.

 Example 3: 

Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

 Notes: 
 If the two linked lists have no intersection at all, return null. 
 The linked lists must retain their original structure after the function returns. 
 You may assume there are no cycles anywhere in the entire linked structure. 
 Your code should preferably run in O(n) time and use only O(1) memory. 

```

### 翻译:
> 编写一个程序，找出两个单链表相交的起始点。  
> 例如，以下两个链表:  
> 从节点c1开始相交。  
> 示例1:  
>
> 输入:intersectVal = 8, listA = [4,1,8,4,5]， listB = [5,0,1,8,4,5]， skipA = 2, skipB = 3  
> 输出:值为8的节点的引用  
> 输入说明:相交节点的值为8(注意，如果两个列表相交，这个值不能为0)。从A的头部开始，它读起来是[4,1,8,4,5]。从B的头部开始，它读起来是[5,0,1,8,4,5]。A中相交节点前有2个节点;B中的交点之前有3个节点。  
>
> 示例2:  
>
> 输入:intersectVal = 2, listA = [0,9,1,2,4]， listB = [3,2,4]， skipA = 3, skipB = 1  
> 输出:值为2的节点的引用  
> 输入说明:相交节点的值为2(注意，如果两个列表相交，这个值不能为0)。从A的头部开始，它读起来是[0,9,1,2,4]。从B的头部开始，它读作[3,2,4]。A中相交 节点前有3个节点;在B的交点之前有一个节点。  
>
> 示例3:  
>
> 输入:intersectVal = 0, listA = [2,6,4]， listB = [1,5]， skipA = 3, skipB = 2  
> 输出:零  
> 输入说明:从A的头部开始，读作[2,6,4]。从B的头部开始，它读作[1,5]。由于两个列表不相交，intersectVal必须为0，而skipA和skipB可以是任意值。  
> 说明:两个列表不相交，因此返回null。  
>
> 注:  
> 如果两个链表没有交集，返回null。  
> 在函数返回后，链表必须保留其原始结构。  
> 您可以假设在整个链接结构的任何地方都没有循环。  
> 您的代码最好在O(n)时间内运行，并且只使用O(1)内存。  

---

## 解题思路

本题是要查询两个链表是否有共同的节点，虽然题目很长，但是目标很明确，这题其实也不难。我们知道要判断链表是否有交集，其实只要找到第一个交点就好，就像衣服的拉链一样，第一反应应该是我们可以遍历的方式，但是链表不太适合循环遍历的方式。那么换一种方式，我们在拉衣服拉链的时候需要先把两个链对齐，从底部来拉，那么这个是不是也可以用这个方式，但是单向链表逆向遍历也不方便，那么我们只能手动把头部先对齐，然后往下判断是否有相等的，这边就有个特殊点，一旦交点，说明长度是一样的。所以可以一起往下遍历

## 解题方法

1. 按照思路方式：

   ```
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        int countA = 0;
        int countB = 0;
        while (true) {
            if (tempA != null) {
                tempA = tempA.next;
                countA++;
            }
            if (tempB != null) {
                tempB = tempB.next;
                countB++;
            }
            if (tempA == null && tempB == null) {
                break;
            }
        }
        tempA = headA;
        tempB = headB;
        int maxLength = Math.max(countA, countB);
        while (maxLength > 0) {
            if (maxLength > countA) {
                tempB = tempB.next;
                maxLength--;
                continue;
            }
            if (maxLength > countB) {
                tempA = tempA.next;
                maxLength--;
                continue;
            }
            //先移除两者不相等
            //然后逐步比较，相等才是前提
            if (tempA == null || tempB == null) {
                return null;
            }
            if (tempA.equals(tempB)) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
            maxLength--;

        }
        return null;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
   ```

   **时间复杂度**:
   该方案用中，使用了两次链表的遍历，所以为O(n)=f(2n)=O(n)

   **空间复杂度**:
   该方案用中，没有使用额外的空间，所以为O(n)=f(1)=O(1)

## 总结

本题的大致解法如上所诉，只要知道重合链的特点，其实这题就很简单了。

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
