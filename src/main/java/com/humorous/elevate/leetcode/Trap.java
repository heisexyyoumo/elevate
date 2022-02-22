package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. 接雨水
 */
public class Trap {


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trap().trap(height));
    }


    // 单调栈解法
    // 单调递减栈维持接雨水的左边界，有比左边界的值大的时候表示可以接雨水
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();

        // 单调递减栈
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int pop = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[pop]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int width = i - stack.peek() - 1;
                    int high = Math.min(height[i], height[stack.peek()]) - height[pop];
                    res += width * high;
                }

            }
            stack.push(i);
        }

        return res;
    }


    // 动态规划
    public int trap2(int[] height) {
        int ans = 0;
        int len = height.length;
        if (len == 0) {
            return ans;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                ans += (min - height[i]);
            }
        }

        return ans;
    }

    public int trap3(int[] height) {
        return 0;
    }
}
