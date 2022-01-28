package com.humorous.elevate.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 347. 前 K 个高频元素
 * 剑指 Offer II 060. 出现频率最高的 k 个数字
 */
public class TopKInteger {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Pair[] pairs = new Pair[map.keySet().size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pairs[index++] = new Pair(entry.getKey(), entry.getValue());
        }

        // 堆排，最小堆
        int len = pairs.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjust(pairs, i, len);
        }

        int[] res = new int[k];
        index = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (index == k) {
                break;
            }
            res[index++] = pairs[0].num;

            Pair temp = pairs[0];
            pairs[0] = pairs[i];
            pairs[i] = temp;

            adjust(pairs, 0, i);
        }

        return res;
    }

    private void adjust(Pair[] pairs, int i, int len) {
        Pair temp = pairs[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && pairs[k].count < pairs[k + 1].count) {
                k++;
            }
            if (pairs[k].count > temp.count) {
                pairs[i] = pairs[k];
                i = k;
            } else {
                break;
            }
        }

        pairs[i] = temp;
    }


    private class Pair {
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

}


