package com.humorous.elevate.leetcode;

/**
 * 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new LargestRectangleArea().largestRectangleArea(heights));
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
}
