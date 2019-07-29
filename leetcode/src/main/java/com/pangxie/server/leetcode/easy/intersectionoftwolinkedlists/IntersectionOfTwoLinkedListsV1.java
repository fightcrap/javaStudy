package com.pangxie.server.leetcode.easy.intersectionoftwolinkedlists;

/**
 * Create By fightingcrap On 2019/07/29
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
 * | IntersectionOfTwoLinkedLists
 * |
 * | @author fightingcrap
 **/
public class IntersectionOfTwoLinkedListsV1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA=headA;
        ListNode tempB=headB;
        int count=0;
        while(true){

        }

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
