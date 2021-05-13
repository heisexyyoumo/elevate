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

    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}
