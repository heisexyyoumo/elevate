package com.humorous.elevate.datastructure.sort;

import java.util.Arrays;

/**
 * 快速排序是对冒泡排序的改进
 * 时间复杂度： O(nlogn)，最坏情况(O(n^2))
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static int partition(int[] arr, int left, int right) {
        int val = arr[left];
        while (left < right) {
            while (arr[right] > val && left < right) {
                right--;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }

            // 现在是 arr[right] 需要填坑了
            while (val >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = val;
        return left;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1 || left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
}
