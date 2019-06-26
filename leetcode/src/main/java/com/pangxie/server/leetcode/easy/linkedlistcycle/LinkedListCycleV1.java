package com.pangxie.server.leetcode.easy.linkedlistcycle;

/**
 * Create By fightingcrap On 2019/06/26
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
 * | LinkedListCycleV1
 * |
 * | @author fightingcrap
 **/
public class LinkedListCycleV1 {

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

}
