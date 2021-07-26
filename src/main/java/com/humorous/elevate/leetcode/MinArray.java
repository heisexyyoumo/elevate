package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class MinArray {

    public static void main(String[] args) {
        int[] numbers = {3, 3, 1, 3};
        System.out.println(new MinArray().minArray(numbers));
    }

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}
