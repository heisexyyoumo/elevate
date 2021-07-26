package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. 接雨水
 */
public class Trap {


    public static void main(String[] args) {
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        System.out.println(new Trap().trap(height));

        System.out.println(new Trap().solve(-4, 3));
        System.out.println(23 % 12);
    }

    public String solve(int M, int N) {
        // write code here

        if (M < 0) {
            N = -N;
        }
        StringBuilder sb = new StringBuilder();
        while (M != 0) {
            sb.append(handle(M % N));
            M = M / N;
        }
        if (M < 0) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public char handle(int num) {
        if (num >= 0 && num < 10) {
            return (char) ('0' + num);
        } else {
            return (char) ('A' + num - 10);
        }
    }

    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(height[i], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(i);
        }
        return ans;
    }
}
