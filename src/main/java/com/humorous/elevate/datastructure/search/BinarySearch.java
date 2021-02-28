package com.humorous.elevate.datastructure.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9};
        List<Integer> list = binarySearch2(arr, 9, 0, arr.length);
        list.forEach(System.out::print);

    }


    public static int binarySearch(int[] arr, int val, int l, int r) {
        if (l > r) {
            return -1;
        }
        int m = l + (r - l) / 2;
        if (arr[m] == val) {
            return m;
        } else if (arr[m] < val) {
            return binarySearch(arr, val, m + 1, r);
        } else {
            return binarySearch(arr, val, l, m - 1);
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int val, int l, int r) {
        if (l > r) {
            return new ArrayList<>(1);
        }
        int m = l + (r - l) / 2;
        if (arr[m] == val) {
            List<Integer> list = new ArrayList<>();
            int temp = m - 1;
            while (temp >= 0 && arr[temp] == val) {
                list.add(temp--);
            }
            list.add(m);
            temp = m + 1;
            while (temp <= arr.length - 1 && arr[temp] == val) {
                list.add(temp++);
            }
            return list;
        } else if (arr[m] < val) {
            return binarySearch2(arr, val, m + 1, r);
        } else {
            return binarySearch2(arr, val, l, m - 1);
        }

    }
}
