package com.humorous.elevate.leetcode;

import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * 两个队列实现栈
 */
public class MyStack {

    private LinkedList<Integer> queue1;
    private LinkedList<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue2.addLast(x);
        while (!queue1.isEmpty()) {
            Integer first = queue1.removeFirst();
            queue2.addLast(first);
        }
        LinkedList<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.removeFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peekFirst();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
