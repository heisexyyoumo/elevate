package com.humorous.elevate.leetcode;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 位运算
 */
public class IsUnique {
    public boolean isUnique(String astr) {
        int mask = 0;
        for (char ch : astr.toCharArray()) {
            int val = 1 << (ch - 'a');
            if ((mask & val) != 0) {
                return false;
            } else {
                mask |= val;
            }
        }

        return true;
    }
}
