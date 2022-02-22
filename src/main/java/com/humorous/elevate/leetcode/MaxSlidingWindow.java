package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * 单调队列来解决滑动窗口中的最值问题
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = new MaxSlidingWindow().maxSlidingWindow(nums, k);
        for (int num : res) {
            System.out.println(num);
        }
    }

    // 单调递减队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0, index = 0; i < n; i++) {
            if (!deque.isEmpty() && i - k + 1 > deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i - k + 1 >= 0) {
                res[index++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
