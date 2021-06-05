package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 */
public class MyQueue {

    /**
     * 存放数据的栈
     */
    private Deque<Integer> stack1;
    /**
     * 辅助栈
     */
    private Deque<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
