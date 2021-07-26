package com.humorous.elevate.leetcode;

/**
 * 148. 排序链表
 * <p>
 * 分治+归并
 */
public class SortLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        new SortLinkedList().sortList(node1);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode(0);
        pre.next = slow;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            pre = pre.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode head2 = slow;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(head2);
        return merge(h1, h2);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
                cur = cur.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
                cur = cur.next;
            }
        }
        cur.next = (h1 == null ? h2 : h1);
        return dummy.next;
    }
}
