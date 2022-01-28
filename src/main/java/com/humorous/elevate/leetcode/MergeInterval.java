package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 剑指 Offer II 074. 合并区间
 */
public class MergeInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};
//        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] merge = new MergeInterval().merge2(intervals);
        for (int[] nums : merge) {
            System.out.println(Arrays.toString(nums));
        }


    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        int n = intervals.length;
        quickSort(intervals, 0, n - 1);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] val = intervals[i];
            list.add(val);
            for (int j = i + 1; j < n; j++) {
                int[] temp = intervals[j];
                if (val[1] < temp[0]) {
                    i = j - 1;
                    break;
                } else {
                    val[1] = Math.max(val[1], temp[1]);
                    i = j;
                }
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void quickSort(int[][] intervals, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(intervals, left, right);
        quickSort(intervals, left, pivot - 1);
        quickSort(intervals, pivot + 1, right);
    }

    public int partition(int[][] intervals, int left, int right) {
        int[] temp = intervals[left];
        while (left < right) {
            while (left < right && intervals[right][0] > temp[0]) {
                right--;
            }
            if (left < right) {
                intervals[left] = intervals[right];
                left++;
            }
            while (left < right && temp[0] >= intervals[left][0]) {
                left++;
            }
            if (left < right) {
                intervals[right] = intervals[left];
                right--;
            }
        }

        intervals[left] = temp;
        return left;
    }
}
