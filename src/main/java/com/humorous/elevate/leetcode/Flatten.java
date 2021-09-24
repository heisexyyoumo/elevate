package com.humorous.elevate.leetcode;

/**
 * 430. 扁平化多级双向链表
 * 剑指 Offer II 028. 展平多级双向链表
 */
public class Flatten {

    public static void main(String[] args) {
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(4);
        Node2 node5 = new Node2(5);
        Node2 node6 = new Node2(6);
        Node2 node7 = new Node2(7);
        Node2 node8 = new Node2(8);
        Node2 node9 = new Node2(9);
        Node2 node10 = new Node2(10);
        Node2 node11 = new Node2(11);
        Node2 node12 = new Node2(12);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;

        Node2 res = new Flatten().flatten(node1);
        System.out.println();

    }

    public Node2 flatten(Node2 head) {
        if (head == null) {
            return head;
        }
        Node2 cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node2 next = cur.next;
                Node2 node = flatten(cur.child);
                cur.child = null;
                cur.next = node;
                node.prev = cur;
                while (cur.next != null) {
                    cur = cur.next;
                }
                if (next != null) {
                    cur.next = next;
                    next.prev = cur;
                }
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
