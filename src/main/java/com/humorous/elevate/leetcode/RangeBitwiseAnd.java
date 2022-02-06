package com.humorous.elevate.leetcode;

/**
 * 201. 数字范围按位与
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int prefix = 1 << 30;
        int ans = 0;
        while (prefix > 0 && (left & prefix) == (right & prefix)) {
            ans |= left & prefix;
            prefix >>= 1;
        }
        return ans;
    }
}
