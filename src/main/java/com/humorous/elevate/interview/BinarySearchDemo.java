package com.humorous.elevate.interview;

public class BinarySearchDemo {

    public static int binarySearch(int[] arr, int target) {
        int n = arr.length;
        if (n == 0) {
            return -1;
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
