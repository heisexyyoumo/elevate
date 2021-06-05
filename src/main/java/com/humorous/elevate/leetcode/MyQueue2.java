package com.humorous.elevate.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 * 均摊复杂度O(1)
 */
public class MyQueue2 {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    private int first;

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack1.isEmpty()) {
            first = x;
        }
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return first;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
