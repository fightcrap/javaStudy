package com.pangxie.server.leetcode.medium.addtwonumbers;

/**
 * Create By fightingcrap On 2019/10/20
 * |  .--,       .--,
 * |( (  \.---./  ) )
 * | '.__/o   o\__.'
 * |    {=  ^  =}
 * |     >  -  <
 * |    /       \
 * |   //       \\
 * |  //|   .   |\\
 * |  "'\       /'"_.-~^`'-.
 * |     \  _  /--'         `
 * |   ___)( )(___
 * |  (((__) (__)))    程序镇压神兽，排查一切bug。
 * |
 * |
 * | AddTwoNumbersV1
 * |
 * | @author fightingcrap
 **/
public class AddTwoNumbersV1 {

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
}
