package com.humorous.elevate.leetcode;

/**
 * 43. 字符串相乘
 * 分治
 */
public class Multiply {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new Multiply().multiply(num1, num2));
    }

    // 求 num1个nums2相加
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String res = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            res = add(res, multiply(num2, num1, i));
        }
        return res;
    }

    private String multiply(String num2, String num1, int index) {
        int c = num1.charAt(index) - '0';
        if (c == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int var = (num2.charAt(i) - '0') * c + add;
            sb.append(var % 10);
            add = var / 10;
        }
        if (add != 0) {
            sb.append(add);
        }
        StringBuilder reverse = sb.reverse();
        for (int i = index; i < num1.length() - 1; i++) {
            reverse.append('0');
        }
        return reverse.toString();
    }

    public String add(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;
        int add = 0;
        while (index1 >= 0 || index2 >= 0) {
            int var1 = index1 >= 0 ? (str1.charAt(index1--) - '0') : 0;
            int var2 = index2 >= 0 ? (str2.charAt(index2--) - '0') : 0;
            int var = (var1 + var2 + add) % 10;
            add = (var1 + var2 + add) / 10;
            sb.append(var);
        }
        if (add != 0) {
            sb.append(add);
        }
        return sb.reverse().toString();
    }


}
