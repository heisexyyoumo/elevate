package com.humorous.elevate.leetcode;


/**
 * 剑指 Offer II 071. 按权重生成随机数
 * 前缀和 + 二分查找
 */
public class RandomArray {

    int[] prev;
    int total;

    public RandomArray(int[] w) {
        int n = w.length;
        prev = new int[n];
        prev[0] = w[0];
        for (int i = 1; i < n; i++) {
            prev[i] = prev[i - 1] + w[i];
        }
        total = prev[n - 1];
    }

    public int pickIndex() {
        int random = (int) (Math.random() * total) + 1;
        return binarySearch(random);
    }

    public int binarySearch(int random) {
        // 在prev数组中寻找第一个大于等于random的下标
        int n = prev.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (prev[m] >= random) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
