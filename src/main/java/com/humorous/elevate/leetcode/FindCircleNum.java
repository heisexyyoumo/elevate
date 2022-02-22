package com.humorous.elevate.leetcode;

/**
 * 547. 省份数量
 * 剑指 Offer II 116. 省份数量
 * 并查集问题
 */
public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                res++;
            }
        }

        return res;
    }


    public int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY;
    }
}
