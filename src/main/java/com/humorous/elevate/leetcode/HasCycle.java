package com.humorous.elevate.leetcode;

/**
 * 141. 环形链表
 * 快慢指针
 */
public class HasCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode quickNode = head;
        ListNode slowNode = head;
        while (quickNode != null && quickNode.next != null) {
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if (quickNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
