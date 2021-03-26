package com.humorous.elevate.leetcode;

/**
 * 62. 不同路径
 */
public class UniquePaths {


    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7, 3));
    }


    // 动态规划
    // map[i][j]表示走到该位置的走法
    // map[i][j] = map[i-1][j] + map[i][j-1]
    public int uniquePaths(int m, int n) {

        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            map[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }

//    // 下 -> 右
//    int[][] dire = {{1, 0}, {0, 1}};
//    // 记录路径
//    int count;
//
//    // 求从map[0][0]到map[m-1][n-1]的路径总数
//    // 走过设为1,没有设为0
//    public int uniquePaths(int m, int n) {
//        int[][] map = new int[m][n];
//        count = 0;
//
//        map[0][0] = 1;
//        dfs(map, 0, 0, m, n);
//
//        return count;
//    }
//
//    private void dfs(int[][] map, int x, int y, int m, int n) {
//        if (x == m - 1 && y == n - 1) {
//            count++;
//            return;
//        }
//
//        for (int i = 0; i < dire.length; i++) {
//            int newx = x + dire[i][0];
//            int newy = y + dire[i][1];
//            if (isArea(newx, newy, m, n)) {
//                if (map[newx][newy] == 1) {
//                    continue;
//                }
//                map[newx][newy] = 1;
//                dfs(map, newx, newy, m, n);
//                map[newx][newy] = 0;
//            }
//        }
//
//
//    }
//
//    public boolean isArea(int x, int y, int m, int n) {
//        return x >= 0 && x < m && y >= 0 && y < n;
//    }
}
