package com.humorous.elevate.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 329. 矩阵中的最长递增路径
 */
public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        new LongestIncreasingPath().longestIncreasingPath(matrix);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] outDegrees = new int[m][n];
        // 上 -> 右 -> 下 -> 左
        int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < direct.length; k++) {
                    int newi = i + direct[k][0];
                    int newj = j + direct[k][1];
                    if (isInArea(newi, newj, m, n) && matrix[newi][newj] > matrix[i][j]) {
                        outDegrees[i][j]++;
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (outDegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }


        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                int[] poll = queue.poll();
                for (int[] d : direct) {
                    int x = poll[0];
                    int y = poll[1];
                    int newx = x + d[0];
                    int newy = y + d[1];
                    if (isInArea(newx, newy, m, n) && matrix[newx][newy] < matrix[x][y] &&
                            --outDegrees[newx][newy] == 0) {
                        queue.offer(new int[]{newx, newy});
                    }
                }
            }

        }

        return ans;
    }


    public boolean isInArea(int x, int y, int m, int n) {
        return 0 <= x && 0 <= y && x < m && y < n;
    }
}
