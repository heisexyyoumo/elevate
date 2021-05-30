package com.humorous.elevate.leetcode;

/**
 * 200. 岛屿数量
 */
public class NumIslands {

    boolean[][] visited;
    // 右->下->左->上
    int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, m, n);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int x, int y, int m, int n) {
        visited[x][y] = true;
        for (int i = 0; i < dire.length; i++) {
            int newx = x + dire[i][0];
            int newy = y + dire[i][1];
            if (isArea(newx, newy, m, n) && !visited[newx][newy] && grid[newx][newy] == '1') {
                dfs(grid, newx, newy, m, n);
            }
        }
    }


    public boolean isArea(int x, int y, int m, int n) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }


}
