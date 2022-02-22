package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. 最小栈
 * 面试题 03.02. 栈的最小值
 * 一个辅助栈
 */
public class MinStack {

    Deque<int[]> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
