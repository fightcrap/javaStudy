# LeetCode集锦（七） - 第21题 Merge Two Sorted List

## 问题

```
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists. 

 Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4



  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

```
### 翻译:
> 合并两个已排序的链表，并将其作为一个新列表返回。新列表应该通过将前两个列表的节点拼接在一起来创建。  
> 例子:  
> 输入:1 - > 2 - > 4,1 - > 3 - > 4  
> 输出:1 - > 1 - > 2 - > 3 - > 4 - > 4  
> 数据格式：  
> ```
> public class ListNode {
>      int val;
>     ListNode next;
>      ListNode(int x) { val = x; }
> }
> ```

---
## 解题思路
本题思路很简单，就是合并两个链表，通过遍历对方式，逐步把另外一个链合并到新的链里面去，我们这边需要额外到两个节点，一个是头节点，因为在遍历的时候需要保证链头还在，才可以返回数据。还有一个是遍历时，当前节点的前一节点。因为可能会插在前面的节点上。

## 解题方法
1. 第一种解题方法，我这边使用了l1为基本链，把l2合并到l1中，新建立了链头，这样方便直接插入比l1头部还小的链，代码如下
    ```
    if (l1 == null) {
            return l2;
        }
        ListNode start = new ListNode(0);
        start.next = l1;
        ListNode before = start;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode temp = l2;
                l2 = l2.next;
                before.next = temp;
                temp.next = l1;
                before = temp;
            } else {
                before = l1;
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            before.next = l2;
        }
        return start.next;
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为1，循环次数为l1或l2的最小长度，所以T(n)=O(n)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

## 总结
本题的大致解法如上所诉，本题只想到了一种方法，直接按照思路来。