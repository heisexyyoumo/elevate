package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 148 排序链表
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        for (Integer val : list) {
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;
        return dummyHead.next;
    }
}
