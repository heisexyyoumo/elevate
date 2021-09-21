package com.humorous.elevate.leetcode;


/**
 * 142. 环形链表 II
 * 快慢指针
 * 剑指 Offer II 022. 链表中环的入口节点
 */
public class DetectCycle {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        new DetectCycle().detectCycle(node1);
    }

    // a + b
    // a = 2, b = 3
    // 1 -> 2 -> 3 -> 4 -> 5 -> 3 -> 4 -> 5 ....
    // f = 2s,f - s = nb ==> f = 2nb, s = nb
    //
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }
        fast = head;
        while (true) {
            if (fast == slow) {
                return fast;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
    }


    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
