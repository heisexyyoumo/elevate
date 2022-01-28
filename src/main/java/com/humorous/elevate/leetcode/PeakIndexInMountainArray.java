package com.humorous.elevate.leetcode;

/**
 * 852. 山脉数组的峰顶索引
 * 剑指 Offer II 069. 山峰数组的顶部
 */
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 2, 0};
        int index = new PeakIndexInMountainArray().peakIndexInMountainArray(arr);
        System.out.println(index);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (m + 1 <= r && arr[m] > arr[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

}
