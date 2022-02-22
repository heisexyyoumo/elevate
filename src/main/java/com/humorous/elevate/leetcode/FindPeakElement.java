package com.humorous.elevate.leetcode;

/**
 * 162. 寻找峰值
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m + 1 <= r && nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    /**
     * 优化：当 m + 1 <= r为false时，此时 m = r == >  l = m = r == > l = r，此时已不满足while循环
     * 故不会出现 m + 1 <= r 为false的场景
     */
    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
