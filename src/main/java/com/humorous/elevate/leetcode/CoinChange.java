package com.humorous.elevate.leetcode;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new CoinChange().coinChange(coins, 0));
    }

    public int coinChange(int[] coins, int amount) {
        // dp[n] 表示 amount为n的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int n = 1; n < amount + 1; n++) {
            for (int i = 0; i < coins.length; i++) {
                int val = n - coins[i];
                if (val < 0) {
                    continue;
                } else {
                    int num = dp[val] == -1 ? -1 : (1 + dp[val]);
                    if (dp[n] == -1) {
                        dp[n] = num;
                    } else {
                        if (num != -1) {
                            dp[n] = Math.min(dp[n], num);
                        }
                    }
                }
            }
        }

        return dp[amount];
    }
}
