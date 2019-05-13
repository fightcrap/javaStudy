package com.pangxie.server.leetcode.easy.mergetwosortedlist;

/**
 * Create By fightingcrap On 2019/05/11
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
 * | MergeTwoSortedListV1
 * |
 * | @author fightingcrap
 **/
public class MergeTwoSortedListV1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

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

    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
