package com.humorous.elevate.leetcode;

import java.util.Stack;

/**
 * 66. 加一
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int add = 1;  // 进位
        Stack<Integer> stack = new Stack<>();
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int val = (digits[i] + add) % 10;
            add = (digits[i] + add) / 10;
            stack.push(val);
        }
        if (add == 1) {
            stack.push(add);
        }

        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
}
