package com.humorous.elevate.algorithm;

public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9};
//        List<Integer> list = binarySearch2(arr, 9, 0, arr.length);
//        list.forEach(System.out::print);
        System.out.println(binarySearch(arr, 11));

    }


    /**
     * 二分查找算法 -- 非递归实现
     *
     * @param arr
     * @param val
     * @return
     */
    public static int binarySearch(int[] arr, int val) {
        int l = 0;
        int r = arr.length - 1;
        int m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] == val) {
                return m;
            } else if (arr[m] > val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
