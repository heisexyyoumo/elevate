package com.humorous.elevate.leetcode;

public class DeleteDuplicatesI {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }

        return head;
    }
}
