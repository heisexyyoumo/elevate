package com.humorous.elevate.leetcode;

/**
 * 注意链表反转需要三个指针，pre,cur,next
 * 每次只将一个next指针变向
 * 最后返回pre
 */

public class ReverseBetween {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        new ReverseBetween().reverseBetween(head, 2, 4);

    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 创建虚拟头结点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        int index = 0;
        while (index + 1 < left) {
            cur = cur.next;
            index++;
        }
        ListNode lp = cur;
        index++;
        cur = cur.next;  //次数cur执行left位置,index = left
        ListNode pre = null;
        while (index <= right) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            index++;

        }
        //出while循环时，此时cur执行right+1的位置,index = right+1
        lp.next.next = cur;
        lp.next = pre;
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

