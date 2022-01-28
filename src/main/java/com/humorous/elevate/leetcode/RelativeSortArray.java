package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer II 075. 数组相对排序
 * 核心是数组的自定义排序
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        new RelativeSortArray().relativeSortArray2(arr1, arr2);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[arr1.length];
        int index = 0;
        for (int num : arr2) {
            int count = map.get(num);
            map.remove(num);
            for (int i = 0; i < count; i++) {
                res[index++] = num;
            }
        }

        if (index == arr1.length) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        for (Integer num : map.keySet()) {
            int count = map.get(num);
            for (int i = 0; i < count; i++) {
                list.add(num);
            }
        }
        quickSort(list, 0, list.size() - 1);
        for (int num : list) {
            res[index++] = num;
        }

        return res;
    }

    public void quickSort(List<Integer> list, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(list, l, r);
        quickSort(list, l, pivot - 1);
        quickSort(list, pivot + 1, r);
    }

    public int partition(List<Integer> list, int l, int r) {
        int temp = list.get(l);
        while (l < r) {
            while (l < r && list.get(r) > temp) {
                r--;
            }
            if (l < r) {
                list.set(l, list.get(r));
                l++;
            }
            while (l < r && list.get(l) <= temp) {
                l++;
            }
            if (l < r) {
                list.set(r, list.get(l));
                r--;
            }
        }

        list.set(l, temp);
        return l;
    }


    /**
     * 在数组的值的数据范围不是很大的情况下，可以使用计数排序
     * 0 <= arr1[i], arr2[i] <= 1000
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int max = 0;
        for (int num : arr1) {
            max = Math.max(num, max);
        }

        int[] freq = new int[max + 1];
        for (int num : arr1) {
            freq[num]++;
        }

        int[] res = new int[arr1.length];
        int index = 0;
        for (int num : arr2) {
            int count = freq[num];
            for (int i = 0; i < count; i++) {
                res[index++] = num;
            }
            freq[num] = 0;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                int count = freq[i];
                for (int j = 0; j < count; j++) {
                    res[index++] = i;
                }
            }
        }

        return res;
    }
}
