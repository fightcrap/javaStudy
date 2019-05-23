package com.pangxie.server.leetcode.easy.removeduplicatesfromsortedlist;

/**
 * Create By fightingcrap On 2019/05/23
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
 * | RemoveDuplicatesFromSortedListV1
 * |
 * | @author fightingcrap
 **/
public class RemoveDuplicatesFromSortedListV1 {

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
}


