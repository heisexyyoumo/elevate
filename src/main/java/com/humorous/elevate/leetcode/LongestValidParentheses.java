package com.humorous.elevate.leetcode;

/**
 * 32. 最长有效括号
 * 从左向右求一遍 和 从右向左求一遍 取最大值
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // (()
        int max1 = work(s);

        // ())
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            // '(' 与 ')'的ascii码值只有末位不同，故用异或运算翻转
            char c = (char) (s.charAt(i) ^ 1);
            sb.append(c);
        }
        int max2 = work(sb.toString());
        return Math.max(max1, max2);
    }

    public int work(String s) {
        int res = 0;
        for (int i = 0, start = 0, cnt = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0) {
                    start = i + 1;
                    cnt = 0;
                } else if (cnt == 0) {
                    res = Math.max(res, i - start + 1);
                }
            }
        }

        return res;
    }
}
