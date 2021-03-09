package com.humorous.elevate.leetcode;


/**
 * leetcode 474题
 */
public class FindMaxForm {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(new FindMaxForm().findMaxForm(strs, 5, 3));
    }


//    //dp[i][j][k]表示[0,i]范围内满足0的个数小于j,1的个数小于m
//    public int findMaxForm(String[] strs, int m, int n) {
//        int[][][] dp = new int[strs.length][m + 1][n + 1];
//        int num0 = strs[0].length() - numOf1(strs[0]);
//        int num1 = numOf1(strs[0]);
//        for (int j = 0; j <= m; j++) {
//            for (int k = 0; k <= n; k++) {
//                dp[0][j][k] = ((j >= num0 && k >= num1) ? 1 : 0);
//            }
//        }
//
//        for (int i = 1; i < strs.length; i++) {
//            for (int j = 0; j <= m; j++) {
//                for (int k = 0; k <= n; k++) {
//                    int res = dp[i - 1][j][k];
//                    num0 = strs[i].length() - numOf1(strs[i]);
//                    num1 = numOf1(strs[i]);
//                    if (j >= num0 && k >= num1) {
//                        res = Math.max(res, 1 + dp[i - 1][j - num0][k - num1]);
//                    }
//                    dp[i][j][k] = res;
//                }
//            }
//        }
//
//        return dp[strs.length - 1][m][n];
//
//    }


    // 空间复杂度优化
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int num0 = strs[0].length() - numOf1(strs[0]);
        int num1 = numOf1(strs[0]);
        for (int j = 0; j <= m; j++) {
            for (int k = 0; k <= n; k++) {
                dp[j][k] = ((j >= num0 && k >= num1) ? 1 : 0);
            }
        }

        for (int i = 1; i < strs.length; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= num0 && k >= num1) {
                        num0 = strs[i].length() - numOf1(strs[i]);
                        num1 = numOf1(strs[i]);
                        dp[j][k] = Math.max(dp[j][k], 1 + dp[j - num0][k - num1]);
                    }
                }
            }
        }
        return dp[m][n];
    }


    /**
     * 字符串中1的个数
     *
     * @param str
     * @return
     */
    public int numOf1(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                num++;
            }
        }
        return num;
    }

}
