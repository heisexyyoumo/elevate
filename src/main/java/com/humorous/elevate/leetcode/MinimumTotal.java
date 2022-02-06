package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 剑指 Offer II 100. 三角形中最小路径之和
 */
public class MinimumTotal {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(new MinimumTotal().minimumTotal(list));

    }

    /**
     * O(n)空间复杂度
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i] = Math.min(dp[i],dp[i-1]) + triangle[i][i];
        int[] dp = new int[n];
        Arrays.fill(dp, 10001);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[0] = dp[0] + triangle.get(i).get(0);
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[i], min);
        }

        return min;
    }
}
