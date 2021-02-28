package com.humorous.elevate.datastructure.sort;

import java.util.Arrays;

/**
 * 基数排序，也称桶排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 2, 7, 9, 1, 8, 5};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {

        int[][] bucket = new int[10][arr.length];
        int[] num = new int[10]; // 表示每个桶中放入的数的个数

        //计算数组中的最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        int index = 0;
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int val = arr[j] / n % 10;
                bucket[val][num[val]++] = arr[j];
            }

            for (int k = 0; k < num.length; k++) {
                if (num[k] != 0) {
                    for (int j = 0; j < num[k]; j++) {
                        arr[index++] = bucket[k][num[j]];
                    }
                }
                num[k] = 0;
            }
            index = 0;

        }
    }
}
