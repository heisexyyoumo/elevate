package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题 16.19. 水域大小
 */
public class PondSizes {


    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        int[] sizes = new PondSizes().pondSizes(land);
        System.out.println(Arrays.toString(sizes));
    }

    // 八个方向，顺序为右-右下-下-左下-左-坐上-上-右上
    int[][] dire = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    //表示是否被访问过
    boolean[][] visited;
    int count;

    public int[] pondSizes(int[][] land) {
        visited = new boolean[land.length][land[0].length];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    count = 1;
                    list.add(dfs(land, i, j));
                }
            }
        }
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(res);
        return res;
    }

    private int dfs(int[][] land, int x, int y) {

        for (int i = 0; i < dire.length; i++) {
            int newx = dire[i][0] + x;
            int newy = dire[i][1] + y;
            if (isArea(land, newx, newy) && !visited[newx][newy] && land[newx][newy] == 0) {
                visited[newx][newy] = true;
                count = 1 + dfs(land, newx, newy);
            }
        }
        return count;
    }

    public boolean isArea(int[][] land, int x, int y) {
        return x >= 0 && y >= 0 && x < land.length && y < land[0].length;
    }
}
