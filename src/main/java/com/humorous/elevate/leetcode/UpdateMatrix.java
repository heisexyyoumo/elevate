package com.humorous.elevate.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 * 剑指 Offer II 107. 矩阵中的距离
 * 图中的最短路径问题可以考虑广度优先搜索
 */
public class UpdateMatrix {


    public static void main(String[] args) {
        int[][] mat = {{0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};
        int[][] res = new UpdateMatrix().updateMatrix(mat);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }

    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] direction = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            for (int k = 0; k < 4; k++) {
                int ni = i + direction[k][0];
                int nj = j + direction[k][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }
        }

        return dist;
    }

}
