package com.humorous.elevate.leetcode;

/**
 * 13. 罗马数字转整数
 */
public class RomanToInt {

    public static void main(String[] args) {
        String s = "MDCXCV";
        System.out.println(new RomanToInt().romanToInt(s));
    }

    public int romanToInt(String s) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int res = 0;
        int index = 0;
        int start = 0;
        String sub1 = null;
        String sub2 = null;
        while (index < nums.length && start < s.length()) {
            sub1 = s.substring(start, start + 1);
            if (start + 1 < s.length()) {
                sub2 = s.substring(start, start + 2);
            } else {
                sub2 = null;
            }
            if (sub1.equals(romans[index])) {
                res += nums[index];
                start++;
                continue;
            }
            if (sub2 != null && sub2.equals(romans[index])) {
                res += nums[index];
                start += 2;
                continue;
            }
            index++;
        }

        return res;
    }

}
