package com.humorous.elevate.leetcode;

/**
 * 6. Z 字形变换
 */
public class ZConvert {

    public static void main(String[] args) {
        String s = "A";
        System.out.println(new ZConvert().convert(s, 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 找规律题，寻找时建议用下标来模拟验证
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < len; j += 2 * (numRows - 1)) {
                    sb.append(s.charAt(j));
                }
            } else {
                for (int j = i, k = 2 * (numRows - 1) - i; j < len || k < len; j += 2 * (numRows - 1), k += 2 * (numRows - 1)) {
                    if (j < len) {
                        sb.append(s.charAt(j));
                    }
                    if (k < len) {
                        sb.append(s.charAt(k));
                    }
                }
            }
        }

        return sb.toString();
    }
}
