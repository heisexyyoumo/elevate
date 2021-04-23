package com.humorous.elevate.leetcode;

/**
 * 171. Excel表列序号
 * 本质26进制
 */
public class TitleToNumber {

    public static void main(String[] args) {
        String columnTitle = "ZY";
        System.out.println(new TitleToNumber().titleToNumber(columnTitle));
    }

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int n = chars.length;
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += 26 * i * (chars[i] - 'A' + 1) + (chars[i] - 'A' + 1);
        }
        return res;
    }
}
