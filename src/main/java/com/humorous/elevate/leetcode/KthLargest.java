package com.humorous.elevate.leetcode;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * 剑指 Offer II 059. 数据流的第 K 大数值
 */
public class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }


    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
