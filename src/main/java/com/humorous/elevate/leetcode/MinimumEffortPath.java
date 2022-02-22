package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1631. 最小体力消耗路径
 */
public class MinimumEffortPath {

    public static void main(String[] args) {
        int[][] heights = {{4, 3, 4, 10, 5, 5, 9, 2}, {10, 8, 2, 10, 9, 7, 5, 6}, {5, 8, 10, 10, 10, 7, 4, 2},
                {5, 1, 3, 1, 1, 3, 1, 9}, {6, 4, 10, 6, 10, 9, 4, 6}};
        new MinimumEffortPath().minimumEffortPath(heights);
    }

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int id = i * cols + j;
                if (i > 0) {
                    edges.add(new int[]{id - cols, id, Math.abs(heights[i - 1][j] - heights[i][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j - 1] - heights[i][j])});
                }
            }
        }

        // 按照权值排序
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int res = 0;
        UnionFind unionFind = new UnionFind(rows * cols);
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            int var = edge[2];
            unionFind.union(first, second);
            if (unionFind.isConnected(0, rows * cols - 1)) {
                res = var;
                break;
            }
        }

        return res;
    }

    class UnionFind {
        int[] parent;
        int n;

        public UnionFind(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }
    }
}
