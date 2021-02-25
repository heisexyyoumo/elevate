package com.humorous.elevate.datastructure.sort;

/**
 * 冒泡排序算法
 * 相邻的两个数比较
 * 排序的次数（大循环）为数组的长度-1
 * 每次排序比较的数都在减少
 * 当有一次排序没有任何交换，就退出排序过程，此时数据已经有序了--冒泡排序的优化
 * 时间复杂度：O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        bubbleSort(arr);

    }

    public static void bubbleSort(int[] arr) {
        boolean flag = false;  // 标识变量，表示是否进行过交换
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
