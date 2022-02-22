package com.humorous.elevate.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 918. 环形子数组的最大和
 */
public class MaxSubarraySumCircular {


    public int maxSubarraySumCircular(int[] nums) {
        // 根据题意，子数组最多只能包含固定缓冲区中的每个元素一次，即子数组的最大长度为n，故可以把环形数组展开为2n的普通数组

        int n = nums.length;
        int[] temp = new int[2 * n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
            temp[i + n] = nums[i];
        }

        int[] sum = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            sum[i] = sum[i - 1] + temp[i - 1];
        }

        // 题意转换为：对每个sum[i]求[i-n,i]范围内的最小的sum[j]，使得sum[i] - sum[j]最大
        // 此时就可以使用单调递增队列求解
        Deque<Integer> deque = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= 2 * n; i++) {
            if (!deque.isEmpty() && i - n > deque.peekFirst()) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                res = Math.max(res, sum[i] - sum[deque.peekFirst()]);
            }
            while (!deque.isEmpty() && sum[deque.peekLast()] >= sum[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res;
    }
}
