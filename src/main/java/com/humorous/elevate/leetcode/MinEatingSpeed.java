package com.humorous.elevate.leetcode;

/**
 * 875. 爱吃香蕉的珂珂
 * 剑指 Offer II 073. 狒狒吃香蕉
 * 找出最小的速度和最大的速度，通过二分查找快速找到需要的值
 */
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 0;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        int l = 1;
        int r = maxVal;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (calculateHour(piles, m) > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public int calculateHour(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }

        return sum;
    }
}
