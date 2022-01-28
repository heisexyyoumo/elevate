package com.humorous.elevate.leetcode;


/**
 * 剑指 Offer II 029. 排序的循环链表
 */
public class Insert {

    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        node5.next = node1;
        node1.next = node3;
        node3.next = node5;

        new Insert().insert2(node5,0);
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }


        int max = head.val;
        int min = head.val;
        Node cur = head.next;
        while (cur != head) {
            max = Math.max(cur.val, max);
            min = Math.min(cur.val, min);
            cur = cur.next;
        }
        if (min < max) {
            if (insertVal <= min || insertVal >= max) {
                // 比现有的都小，找到最大的
                // 比现有的都大，找到最大的
                while (cur.val < max) {
                    cur = cur.next;
                }
                while (cur != cur.next && cur.val == cur.next.val) {
                    cur = cur.next;
                }

            } else {
                // 在之间，找到前一个比它小，后一个比它大
                while (cur.val > insertVal) {
                    cur = cur.next;
                }
                // 此时cur.val <= insertVal
                while (cur.next.val <= insertVal) {
                    cur = cur.next;
                }
                // 此时cur.next.val > insertVal
            }
        }

        Node next = cur.next;
        Node node = new Node(insertVal);
        cur.next = node;
        node.next = next;

        return head;
    }

    public Node insert2(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node cur = head;
        Node min = cur;
        Node max = cur;
        while(cur.next != head){
            if(cur.next.val >= max.val){
                max = cur.next;
            }
            if(cur.next.val < min.val){
                min = cur.next;
            }
            cur = cur.next;
        }

        if(insertVal >= max.val || insertVal <= min.val){
            Node node = new Node(insertVal);
            max.next = node;
            node.next = min;
            return head;
        }else {
            cur = min;
            while(cur.next.val < insertVal){
                cur = cur.next;
            }

            Node next = cur.next;
            Node node = new Node(insertVal);
            node.next = next;
            cur.next = node;
            return head;


        }



    }
}
