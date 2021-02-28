package com.humorous.elevate.datastructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度 O(nlogn)
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] arr) {

        //先建一个大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }

        //取堆顶元素交换到最后一位，然后再建堆，再交换
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            adjust(arr, 0, j);

        }
    }

    //调整非叶子节点i及其子树，使得i所在的位置取到最大值
    //length为调整的总数
    public static void adjust(int[] arr, int i, int length) {
        int temp = arr[i];

        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; // 最大值在右子树
            }

            //交换
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;   //!!! i 指向 k,继续循环比较
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
