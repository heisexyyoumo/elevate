package com.humorous.elevate.leetcode;

/**
 * 137. 只出现一次的数字 II
 * 剑指 Offer II 004. 只出现一次的数字
 * 对于出现三次的数字，各 二进制位 出现的次数都是 3 的倍数。
 * 因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。
 * 通用写法
 */
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int num : nums) {
                count += num >> bit & 1;
            }
            res += (count % 3) << bit;
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
