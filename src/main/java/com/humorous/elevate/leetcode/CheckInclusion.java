package com.humorous.elevate.leetcode;


import java.util.Arrays;

/**
 * 567. 字符串的排列
 * 剑指 Offer II 014. 字符串中的变位词
 */
public class CheckInclusion {


    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(new CheckInclusion().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] num1 = new int[26];
        int index = 0;
        while (index < s1.length()) {
            num1[s1.charAt(index++) - 'a']++;
        }

        int[] num2 = new int[26];
        int l = 0;
        int r = 0;
        while (r < s1.length()) {
            num2[s2.charAt(r++) - 'a']++;
        }
        while (r < s2.length()) {

            boolean res = Arrays.equals(num1, num2);
            if (res) {
                return res;
            } else {
                num2[s2.charAt(l++) - 'a']--;
                num2[s2.charAt(r++) - 'a']++;
            }
        }

        return Arrays.equals(num1, num2);
    }
}
