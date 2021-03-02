package com.humorous.elevate.algorithm;

/**
 * 动态规划，01背包的问题
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] weight = {1, 4, 3};  //物品的重量
        int[] value = {1500, 3000, 2000};  //物品的价值

        int[][] arr = new int[value.length + 1][5];//行表示有几件物品可放，列表示当前背包重量
        for (int i = 0; i < value.length + 1; i++) {
            arr[i][0] = 0;
        }
        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = 0;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (weight[i - 1] > j) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], value[i - 1] + arr[i - 1][j - weight[i - 1]]);
                }
            }
        }

        System.out.println(arr[3][4]);


    }

}
