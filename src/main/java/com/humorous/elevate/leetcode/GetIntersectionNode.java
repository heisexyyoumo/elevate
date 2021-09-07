package com.humorous.elevate.leetcode;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
                continue;
            }
            if (curB == null) {
                curB = headA;
                continue;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }

}
