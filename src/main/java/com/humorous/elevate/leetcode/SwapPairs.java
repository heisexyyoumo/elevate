package com.humorous.elevate.leetcode;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newHead = new SwapPairs().swapPairs(null);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode dummyHead = pre;
        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next;
            ListNode next = cur.next;

            cur.next = next.next;
            pre.next = next;
            next.next = cur;

            pre = cur;
        }
        return dummyHead.next;
    }

    /**
     * 递归方式
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}
