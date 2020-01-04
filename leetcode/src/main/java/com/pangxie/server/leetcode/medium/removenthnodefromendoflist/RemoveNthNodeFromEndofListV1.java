package com.pangxie.server.leetcode.medium.removenthnodefromendoflist;

/**
 * Create By fightingcrap On 2020/01/04
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
 * | RemoveNthNodeFromEndofListV1
 * |
 * | @author fightingcrap
 **/
public class RemoveNthNodeFromEndofListV1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return head;
        }
        ListNode temp = head;
        ListNode result = head;
        boolean isHeader = true;
        int tempIndex = 0;
        while (temp.next != null) {
            if (tempIndex >= n) {
                result = result.next;
                isHeader = false;
            }
            tempIndex++;
            temp = temp.next;
        }

        if (isHeader && tempIndex < n) {
            head = head.next;
        } else {
            result.next = result.next.next;
        }


        return head;

    }

    public static void main(String[] args) {

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
