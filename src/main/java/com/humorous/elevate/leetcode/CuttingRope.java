package com.humorous.elevate.leetcode;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 */

public class CuttingRope {

    public static void main(String[] args) {
//        System.out.println(new CuttingRope().cuttingRope(10));
        System.out.println((int) Math.pow(10, 9) + 7);

        System.out.println();
    }

    // f(n)表示长度为n能取到的最大值，f(n)=Math.max(1*f(n-1),2*f(n-2),..(n-1)*f(1))
    // 1.不剪 2.剪成两段 3.剪成多段
    public int cuttingRope(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < memo.length; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = max3(memo[i], j * memo[i - j], j * (i - j));
            }
        }
        return memo[n] % ((int) Math.pow(10, 9) + 7);
    }

    public int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }


}
