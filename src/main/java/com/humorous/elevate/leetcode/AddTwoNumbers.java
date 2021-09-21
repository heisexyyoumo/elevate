package com.humorous.elevate.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * while ( A 没完 || B 没完)
 *     A 的当前位
 *     B 的当前位
 *
 *     和 = A 的当前位 + B 的当前位 + 进位carry
 *
 *     当前位 = 和 % 10;
 *     进位 = 和 / 10;
 *
 * 判断还有进位吗
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int num = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + num;
            int val = sum % 10;
            num = sum / 10;
            cur.next = new ListNode(val);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (num > 0) {
            cur.next = new ListNode(num);
        }
        return dummyHead.next;
    }


    /**
     * 不翻转链表，用栈解决
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<Integer>();
        Deque<Integer> stack2 = new LinkedList<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
