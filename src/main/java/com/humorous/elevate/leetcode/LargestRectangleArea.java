package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {4, 2, 0, 3, 2, 5};
        System.out.println(new LargestRectangleArea().largestRectangleArea2(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l <= r) {
            int width = r - l + 1;
            int area = width * (heights[l] < heights[r] ? heights[l++] : heights[r--]);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }


    /**
     * 单调栈解法
     */
    public int largestRectangleArea2(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int pop = stack.pop();
                while (!stack.isEmpty() && heights[stack.peek()] == heights[pop]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int area = (i - stack.peek() - 1) * heights[pop];
                    maxArea = Math.max(area, maxArea);
                } else {
                    int area = i * heights[pop];
                    maxArea = Math.max(area, maxArea);
                }

            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            while (!stack.isEmpty() && heights[stack.peek()] == heights[pop]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                int area = (n - stack.peek() - 1) * heights[pop];
                maxArea = Math.max(area, maxArea);
            } else {
                int area = n * heights[pop];
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }
}
