package com.humorous.elevate.datastructure.sort;

/**
 * 选择排序
 * 每次从[i,arr.length - 1]中找到最小的值，然后和arr[i]进行交换
 * 排序的次数为arr.length-1
 * 每一次排序的第一个假定为最小的值
 * 时间复杂度：O(n^2)，最好O(n^2)，最坏O(n^2)
 * 不稳定排序算法
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        selectSort(arr);

    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
