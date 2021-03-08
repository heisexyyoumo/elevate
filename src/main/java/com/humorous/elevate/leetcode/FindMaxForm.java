package com.humorous.elevate.leetcode;


import java.util.Arrays;

/**
 * leetcode 474题
 */
public class FindMaxForm {

    public static void main(String[] args) {
//        String[] strs = {"10", "0001", "111001", "1", "0"};
        String[] strs = {"10", "0", "1"};
        System.out.print(new FindMaxForm().findMaxForm(strs, 1, 1));
    }

    int[] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[strs.length];
        Arrays.fill(memo, -1);
        return maxForm(strs, 0, m, n);
    }


    //[index,n-1]中满足0的个数小于等于i，1的个数小于等于j的最大子集长度
    private int maxForm(String[] strs, int index, int i, int j) {
        if (i < 0 || j < 0 || index >= strs.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int numOf1 = numOf1(strs[index]);
        int numOf0 = strs[index].length() - numOf1;
        int res = 0;
        res = Math.max(maxForm(strs, index + 1, i, j),
                1 + maxForm(strs, index + 1, i - numOf0, j - numOf1));
        memo[index] = res;
        return res;
    }

    /**
     * 字符串中1的个数
     *
     * @param str
     * @return
     */
    public int numOf1(String str) {
        int n = Integer.parseInt(str);
        int num = 0;
        while (n != 0) {
            n = n & (n - 1);
            num++;
        }
        return num;
    }

}
