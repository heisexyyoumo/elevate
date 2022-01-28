package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 373. 查找和最小的K对数字
 * 剑指 Offer II 061. 和最小的 k 个数对
 */
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len = nums1.length * nums2.length;
        Node[] arr = new Node[len];
        int index = 0;
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                List<Integer> list = new ArrayList<>();
                list.add(num1);
                list.add(num2);
                int sum = num1 + num2;
                arr[index++] = new Node(list, sum);
            }
        }

        // 堆排序
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjust(i, arr, len);
        }
        index = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            if (index == k) {
                break;
            }
            res.add(arr[0].list);
            index++;
            Node temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            adjust(0, arr, i);
        }

        return res;
    }

    private void adjust(int i, Node[] arr, int len) {
        Node temp = arr[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && arr[k + 1].sum < arr[k].sum) {
                k++;
            }
            if (arr[k].sum < temp.sum) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;
    }

    private class Node {
        List<Integer> list;
        int sum;

        public Node(List<Integer> list, int sum) {
            this.list = list;
            this.sum = sum;
        }
    }
}
