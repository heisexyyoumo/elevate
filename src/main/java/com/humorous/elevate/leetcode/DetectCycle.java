package com.humorous.elevate.leetcode;


/**
 * 142. 环形链表 II
 * 快慢指针
 * 剑指 Offer II 022. 链表中环的入口节点
 * 面试题 02.08. 环路检测
 */
public class DetectCycle {

    // a + b
    // a = 2, b = 3
    // 1 -> 2 -> 3 -> 4 -> 5 -> 3 -> 4 -> 5 ....
    // f = 2s,f - s = nb ==> f = 2nb, s = nb
    //
    public ListNode detectCycle(ListNode head) {
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
