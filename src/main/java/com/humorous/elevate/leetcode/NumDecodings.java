package com.humorous.elevate.leetcode;

/**
 * 91. 解码方法
 */
public class NumDecodings {

    public static void main(String[] args) {
        String s = "10";
        System.out.println(new NumDecodings().numDecodings(s));
    }

    // 动态规划
    // memo[i]表示从i开始译码，memo[i] = suit(s[i]) ? memo[i+1] : 0 + suit(s[i,i+1]) ? memo[i+2] ? 0
    public int numDecodings(String s) {
        int n = s.length();
        int[] memo = new int[n];
        memo[n - 1] = canDecoding(s.substring(n - 1)) ? 1 : 0;
        if (n == 1) {
            return memo[n - 1];
        }
        //memo[n - 2] = canDecoding(s.substring(n - 2, n - 1)) ? memo[n - 1] : 0;
        if (canDecoding(s.substring(n - 2, n - 1))) {
            memo[n - 2] = memo[n - 1];
            memo[n - 2] += canDecoding(s.substring(n - 2)) ? 1 : 0;
        }
        if (memo[n - 1] == 0 && memo[n - 2] == 0) {
            return 0;
        }
        for (int i = n - 3; i >= 0; i--) {
            //memo[i] = canDecoding(s.substring(i, i + 1)) ? memo[i + 1] : 0;
            if (canDecoding(s.substring(i, i + 1))) {
                memo[i] = memo[i + 1];
                memo[i] += canDecoding(s.substring(i, i + 2)) ? memo[i + 2] : 0;
            }
        }

        return memo[0];

    }


    public boolean canDecoding(String s) {
        int num = Integer.parseInt(s);
        return num > 0 && num <= 26;
    }
}
