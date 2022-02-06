package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer II 105. 岛屿的最大面积
 * 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    int res = 0;
    boolean[][] visited;
    int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    res = Math.max(dfs(grid, i, j, m, n), res);

                }
            }
        }

        return res;
    }


    public int dfs(int[][] grid, int x, int y, int m, int n) {
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int newx = x + direction[i][0];
            int newy = y + direction[i][1];
            if (isArea(newx, newy, m, n) && !visited[newx][newy] && grid[newx][newy] == 1) {
                visited[newx][newy] = true;
                area += dfs(grid, newx, newy, m, n);
            }
        }

        return area;
    }

    public boolean isArea(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
