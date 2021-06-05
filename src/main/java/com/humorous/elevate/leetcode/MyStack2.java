package com.humorous.elevate.leetcode;


import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * 一个队列
 */
public class MyStack2 {

    private LinkedList<Integer> list;


    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        list = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int n = list.size();
        list.addLast(x);
        for (int i = 0; i < n; i++) {
            list.addLast(list.removeFirst());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return list.removeFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return list.peekFirst();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list.isEmpty();
    }

}
