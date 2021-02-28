package com.humorous.elevate.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid + 1, right);
        }
    }

    //[l,m)左边的数组，[m,r]右边的数组
    public static void merge(int[] arr, int l, int m, int r) {
        int[] leftArr = new int[m - l];
        int[] rightArr = new int[r - m + 1];

        //给数组赋值
        for (int i = l; i <= r; i++) {
            if (i < m) {
                leftArr[i - l] = arr[i];
            } else {
                rightArr[i - m] = arr[i];
            }
        }

        //合并两个有序数组
        int i = 0;
        int j = 0;
        int t = l;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[t++] = leftArr[i++];
            } else {
                arr[t++] = rightArr[j++];
            }
        }
        while (i == leftArr.length && j < rightArr.length) {
            arr[t++] = rightArr[j++];
        }
        while (j == rightArr.length && i < leftArr.length) {
            arr[t++] = leftArr[i++];
        }
    }
}
