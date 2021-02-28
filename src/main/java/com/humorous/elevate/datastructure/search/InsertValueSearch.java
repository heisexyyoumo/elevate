package com.humorous.elevate.datastructure.search;

/**
 * 插值查找，比较适合等比数列的数据列
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(insertValueSearch(arr, 1, 0, arr.length - 1));

    }


    public static int insertValueSearch(int[] arr, int val, int l, int r) {
        //val < arr[0] || val > arr[arr.length - 1] 一定要加上
        if (l > r || val < arr[0] || val > arr[arr.length - 1]) {
            return -1;
        }
        int m = l + (r - l) * (val - arr[l]) / (arr[r] - arr[l]);
        if (arr[m] == val) {
            return m;
        } else if (arr[m] < val) {
            return insertValueSearch(arr, val, m + 1, r);
        } else {
            return insertValueSearch(arr, val, l, m - 1);
        }
    }
}
