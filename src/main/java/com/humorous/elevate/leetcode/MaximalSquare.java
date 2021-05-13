package com.humorous.elevate.leetcode;


/**
 * 221. 最大正方形
 */
public class MaximalSquare {


    public static void main(String[] args) {
//        char[][] matrix = {{'1', '1'}, {'1', '1'}};
//        char[][] matrix = {{'0'}};
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//        char[][] matrix = {{'1', '0', '1', '0'}, {'1', '0', '1', '1'},
//                {'1', '0', '1', '1'}, {'1', '1', '1', '1'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = Math.min(m, n) + 1;
        // dp[i][j][l] 表示已(i,j)为左上角组成长度的l的正方形
        boolean[][][] dp = new boolean[m][n][len];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j][1] = true;
                    max = 1;
                }
            }
        }
        boolean flag = false;
        for (int l = 2; l < len; l++) {
            for (int i = 0; i < m - l + 1; i++) {
                for (int j = 0; j < n - l + 1; j++) {
                    dp[i][j][l] = dp[i][j][l - 1] && dp[i][j + 1][l - 1]
                            && dp[i + 1][j][l - 1] && dp[i + 1][j + 1][l - 1];
                    if (dp[i][j][l]) {
                        flag = true;
                        max = Math.max(l, max);
                    }

                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

        return max * max;
    }
}
