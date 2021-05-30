package com.humorous.elevate.leetcode;

/**
 * 6. Z 字形变换
 */
public class ZConvert {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new ZConvert().convert(s, 4));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int step = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int index = i;
                while (index < s.length()) {
                    sb.append(s.charAt(index));
                    index += step;
                }
            } else {
                int index1 = i;
                int index2 = step - i;
                while (index1 < s.length() || index2 < s.length()) {
                    if (index1 < s.length()) {
                        sb.append(s.charAt(index1));
                        index1 += step;
                    }
                    if (index2 < s.length()) {
                        sb.append(s.charAt(index2));
                        index2 += step;
                    }

                }
            }
        }
        return sb.toString();
    }
}
