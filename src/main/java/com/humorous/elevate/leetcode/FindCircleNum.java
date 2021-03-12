package com.humorous.elevate.leetcode;

/**
 * 547. 省份数量
 * 并查集问题
 */
public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        int[] arr = new int[isConnected.length];  // 数组中存放其父节点的索引，值=下标表示是根节点
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    union(arr, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr[i]) {
                res++;
            }
        }
        return res;
    }

    // 合并
    private void union(int[] arr, int i, int j) {
        int iroot = root(arr, i);
        int jroot = root(arr, j);
        arr[jroot] = iroot;
    }

    // 找到根节点的下标
    private int root(int[] arr, int i) {
        if (arr[i] != i) {
            i = root(arr, arr[i]);
        }
        return i;
    }
}
