package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class SpiralOrder {


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new SpiralOrder().spiralOrder(matrix).toString());
    }

    //方向 右->下->左->上
    int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int index = 0;  //表示先向右走
    boolean[][] visited;

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new boolean[m][n];
        List<Integer> list = new ArrayList<>(m * n);
        bfs(list, matrix, 0, 0, m, n);
        return list;
    }

    private void bfs(List<Integer> list, int[][] matrix, int x, int y, int m, int n) {

        visited[x][y] = true;
        list.add(matrix[x][y]);

        while (true) {

            if (list.size() == (m * n)) {
                break;
            }

            int newx = dire[index][0] + x;
            int newy = dire[index][1] + y;
            if (!isArea(newx, newy, m, n) || visited[newx][newy]) {
                index = (index + 1) % 4;
            } else {
                if (!visited[newx][newy]) {
                    list.add(matrix[newx][newy]);
                    visited[newx][newy] = true;
                    x = newx;
                    y = newy;
                }
            }
        }
    }

    public boolean isArea(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }


    /**
     * 转圈遍历
     */
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
        int nums = m * n;

        while (nums >= 1) {
            for (int i = left; i <= right && nums >= 1; i++) {
                res.add(matrix[top][i]);
                nums--;
            }
            top++;

            for (int i = top; i <= bottom && nums >= 1; i++) {
                res.add(matrix[i][right]);
                nums--;
            }
            right--;

            for (int i = right; i >= left && nums >= 1; i--) {
                res.add(matrix[bottom][i]);
                nums--;
            }
            bottom++;

            for (int i = bottom; i >= top && nums >= 1; i--) {
                res.add(matrix[i][left]);
                nums--;
            }
            left++;
        }
        return res;
    }
}
