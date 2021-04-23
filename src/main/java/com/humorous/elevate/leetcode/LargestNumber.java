package com.humorous.elevate.leetcode;

import java.util.Arrays;

/**
 * 179. 最大数
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {432, 43243};
        System.out.println(new LargestNumber().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        String[] numStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStr[i] = nums[i] + "";
        }
        // 从大到小排
        Arrays.sort(numStr, (x, y) -> {
            String xy = x + y;
            String yx = y + x;
            return yx.compareTo(xy);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : numStr) {
            sb.append(s);
        }
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }

}
