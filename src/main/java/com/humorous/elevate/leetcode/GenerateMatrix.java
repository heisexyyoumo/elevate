package com.humorous.elevate.leetcode;

/**
 * 59. 螺旋矩阵 II
 * 转圈遍历
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while (index <= n * n) {
            for (int i = left; i <= right; i++) {
                res[top][i] = index++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = index++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                res[bottom][i] = index++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                res[i][left] = index++;
            }
            left++;
        }

        return res;
    }
}
