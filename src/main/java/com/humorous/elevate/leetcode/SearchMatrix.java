package com.humorous.elevate.leetcode;

/**
 * 74. 搜索二维矩阵
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        System.out.println(new SearchMatrix().searchMatrix(matrix, 2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length; // 行
        int n = matrix[0].length; // 列

        // 先找打target属于那一行
        int l = 0, r = m - 1;
        int row = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid][0] == target) {
                row = mid;
                break;
            } else if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                if (mid + 1 < m) {
                    if (matrix[mid + 1][0] > target) {
                        row = mid;
                        break;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    row = mid;
                    break;
                }

            }
        }

        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
