package com.humorous.elevate.leetcode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 1765. 地图中的最高点
 * bfs  使用队列+循环解决
 */

public class HighestPeak {

    public static void main(String[] args) {
        int[][] isWater = {{0, 1}, {0, 0}};
        new HighestPeak().highestPeak(isWater);
    }

    int[][] height;
    // 方向：右-下-左-上
    int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] highestPeak(int[][] isWater) {
        height = new int[isWater.length][isWater[0].length];
        for (int[] arr : height) {
            Arrays.fill(arr, -1);
        }
        List<Pair<Integer, Integer>> queue = new LinkedList<>();

        int count = 0;//记录次数
        boolean flag = false;

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    count++;
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            if (flag) {
                break;
            }

            int x = queue.get(0).getKey();
            int y = queue.get(0).getValue();
            queue.remove(0);

            for (int i = 0; i < dire.length; i++) {
                int newx = x + dire[i][0];
                int newy = y + dire[i][1];
                if (isArea(isWater, newx, newy) && height[newx][newy] == -1 && isWater[newx][newy] == 0) {
                    height[newx][newy] = height[x][y] + 1;
                    queue.add(new Pair<>(newx, newy));
                    count++;
                }
                if (count == isWater.length * isWater[0].length) {
                    flag = true;
                }
            }

        }
        return height;
    }

    private boolean isArea(int[][] isWater, int x, int y) {
        return x >= 0 && y >= 0 && x < isWater.length && y < isWater[0].length;
    }

}
