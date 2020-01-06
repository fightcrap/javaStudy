package com.pangxie.server.leetcode.medium.swapnodesinpairs;

/**
 * Create By fightingcrap On 2020/01/06
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
 * | SwapNodesinPairsV1
 * |
 * | @author fightingcrap
 **/
public class SwapNodesinPairsV1 {
    public ListNode swapPairs(ListNode head) {

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
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
