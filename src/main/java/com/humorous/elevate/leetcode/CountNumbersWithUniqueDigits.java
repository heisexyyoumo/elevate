package com.humorous.elevate.leetcode;


/**
 * 357. 计算各个位数不同的数字个数
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 */
public class CountNumbersWithUniqueDigits {


    public static void main(String[] args) {
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2));
    }

    int count = 0;

    public int countNumbersWithUniqueDigits(int n) {
        int[] visited = new int[10];
        count(n, 1, visited);
        return count;
    }


    public void count(int n, int index, int[] visited) {
        count++;
        if (index > n) {
            return;
        }
        //第一次只能取[1,9]
        if (index == 1) {
            for (int i = 1; i <= 9; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    count(n, index + 1, visited);
                    visited[i] = 0;
                }
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    count(n, index + 1, visited);
                    visited[i] = 0;
                }
            }

        }


    }


}
