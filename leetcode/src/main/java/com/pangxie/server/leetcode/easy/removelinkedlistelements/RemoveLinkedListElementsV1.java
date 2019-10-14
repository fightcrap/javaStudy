package com.pangxie.server.leetcode.easy.removelinkedlistelements;

/**
 * Create By fightingcrap On 2019/10/14
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
 * | RemoveLinkedListElementsV1
 * |
 * | @author fightingcrap
 **/
public class RemoveLinkedListElementsV1 {
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
}
