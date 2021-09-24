package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 85. 最大矩形
 * 剑指 Offer II 040. 矩阵中最大的矩形
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        String[] matrix = {"10100", "10111", "11111", "10010"};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }

    public int maximalRectangle(String[] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int[] nums = new int[matrix[0].length()];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            char[] chars = matrix[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    nums[j] += 1;
                } else if (chars[j] == '0') {
                    nums[j] = 0;
                }
            }

            res = Math.max(res, maxArea(nums));
        }

        return res;
    }

    public int maxArea(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        int[] newNums = new int[len + 2];
        newNums[0] = 0;
        for (int i = 0; i < len; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[len + 1] = 0;
        nums = newNums;
        len += 2;

        // 单调栈，存放递增的数据
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (nums[i] < nums[stack.peek()]) {
                int curHeight = nums[stack.pop()];
                int curWidth = i - stack.peek() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.push(i);
        }

        return res;

    }
}
