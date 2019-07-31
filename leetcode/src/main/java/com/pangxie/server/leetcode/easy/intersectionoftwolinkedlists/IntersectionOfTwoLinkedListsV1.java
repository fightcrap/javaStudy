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
}
