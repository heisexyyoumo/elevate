package com.humorous.elevate.datastructure.sort;

/**
 * 插入排序
 * 将n个待排序的元素看成是一个有序表和一个无序表，开始时有序表中只有一个元素，无序表中包含n-1个元素
 * 每次从无序表中选出一个数据，将起放在有序表的某个位置
 * 时间复杂度：O(n^2)，最好	O(n)，最坏O(n^2)
 * 稳定的排序算法。
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {3, 9, -1, 10, -2};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }


}
