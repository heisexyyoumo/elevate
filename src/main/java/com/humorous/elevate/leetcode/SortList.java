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

    /**
     * 归并排序
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode l1 = sortList2(head);
        ListNode l2 = sortList2(newHead);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    /**
     * 快排
     */
    public ListNode sortList3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int num = 0;
        while (cur != null) {
            cur = cur.next;
            num++;
        }
        int[] array = new int[num];
        ListNode newCur = head;
        int index = 0;
        while (newCur != null) {
            array[index++] = newCur.val;
            newCur = newCur.next;
        }
        quickSort(array, 0, num - 1);
        ListNode dummy = new ListNode(0);
        cur = dummy;
        for (int val : array) {
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partion(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }


    public int partion(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] > temp) {
                right--;
            }
            if (left < right) {
                array[left++] = array[right];
            }
            while (left < right && array[left] <= temp) {
                left++;
            }
            if (left < right) {
                array[right--] = array[left];
            }
        }
        array[left] = temp;
        return left;
    }

}
