package com.humorous.elevate.leetcode;

/**
 * 143. 重排链表
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //1.找到中间节点
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        //2.此时slowNode为中间节点，将slowNode后面的节点逆序保存的新的链表中
        ListNode cur = slowNode.next;
        slowNode.next = null;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode reverseHead = pre;
        //3.合并head和reverseHead
        ListNode dummyHead = new ListNode(0);
        ListNode newCur = dummyHead;
        ListNode cur1 = head;
        ListNode cur2 = reverseHead;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                newCur.next = cur1;
                cur1 = cur1.next;
                newCur = newCur.next;
            }
            if (cur2 != null) {
                newCur.next = cur2;
                cur2 = cur2.next;
                newCur = newCur.next;
            }
        }

        head = dummyHead.next;

    }
}
