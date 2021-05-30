package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1738. 找出第 K 大的异或坐标值
 */
public class KthLargestValue {

    public static void main(String[] args) {
        System.out.println(5 ^ 2);
        System.out.println(5 ^ 1);
        System.out.println(6 ^ 2 ^ 5 ^ 1);
        System.out.println(6 ^ 7 ^ 5 ^ 4);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }

        Collections.sort(results, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        return results.get(k - 1);
    }

}
