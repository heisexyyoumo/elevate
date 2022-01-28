package com.humorous.elevate.leetcode;

import java.util.ArrayList;

/**
 * 23. 合并K个升序链表
 * 剑指 Offer II 078. 合并排序链表
 * 归并，分治的思想
 */

public class MergeKLists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }
        int len = lists.size();
        int mid = len / 2;
        ArrayList<ListNode> list1 = new ArrayList<>();
        ArrayList<ListNode> list2 = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            list1.add(lists.get(i));
        }
        for (int i = mid; i < len; i++) {
            list2.add(lists.get(i));
        }
        ListNode node1 = mergeKLists(list1);
        ListNode node2 = mergeKLists(list2);

        return merge(node1, node2);
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                cur.next = node2;
                node2 = node2.next;
                cur = cur.next;
            } else {
                cur.next = node1;
                node1 = node1.next;
                cur = cur.next;
            }
        }
        cur.next = (node1 == null ? node2 : node1);
        return dummy.next;
    }

    /**
     * 不使用额外空间
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeKLists2(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists2(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode leftNode = mergeKLists2(lists, l, mid);
        ListNode rightNode = mergeKLists2(lists, mid + 1, r);
        return merge(leftNode, rightNode);
    }
}

