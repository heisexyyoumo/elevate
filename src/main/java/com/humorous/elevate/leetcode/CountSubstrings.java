package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer II 020. 回文子字符串的个数
 * 647. 回文子串
 */
public class CountSubstrings {

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new CountSubstrings().countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] array = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            array[i][i] = true;
        }

        int count = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j == 1) {
                        array[i][j] = true;
                        count++;
                    } else {
                        array[i][j] = array[i - 1][j + 1];
                        if (array[i][j]) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
