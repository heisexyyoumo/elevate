package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 61. 旋转链表
 */

public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int n = list.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            arr[newIndex] = list.get(i);
        }
        ListNode curNew = new ListNode(arr[0]);
        head = curNew;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(arr[i]);
            curNew.next = node;
            curNew = node;
        }

        return head;
    }
}
