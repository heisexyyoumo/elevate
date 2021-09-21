package com.humorous.elevate.leetcode;

/**
 * 143. 重排链表
 * 剑指 Offer II 026. 重排链表
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(new ReorderList().isPalindrome(node1));
    }

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


    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode rHead = reverse(rightHead);
        ListNode cur1 = head;
        ListNode cur2 = rHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            } else {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }

        return true;

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
