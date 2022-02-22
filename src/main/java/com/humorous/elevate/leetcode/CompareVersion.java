package com.humorous.elevate.leetcode;

/**
 * 165. 比较版本号
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        int l1 = version1.length();
        int l2 = version2.length();
        while (i < l1 || j < l2) {
            int x = i;
            int y = j;
            while (x < l1 && version1.charAt(x) != '.') {
                x++;
            }
            while (y < l2 && version2.charAt(y) != '.') {
                y++;
            }

            // i==x / j==y 这一步判断很巧妙
            int n1 = i == x ? 0 : Integer.parseInt(version1.substring(i, x));
            int n2 = j == y ? 0 : Integer.parseInt(version2.substring(j, y));
            if (n1 < n2) {
                return -1;
            } else if (n1 > n2) {
                return 1;
            }
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }
}