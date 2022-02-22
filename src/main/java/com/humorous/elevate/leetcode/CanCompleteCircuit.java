package com.humorous.elevate.leetcode;

public class CanCompleteCircuit {


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int temp = i;
            totalGas = gas[i] - cost[(i + 1) % n];
            while (totalGas >= 0) {
                temp++;
                if (temp % n == i) {
                    break;
                }
                totalGas = totalGas + gas[temp % n] - cost[(temp + 1) % n];
                if (totalGas < 0) {
                    break;
                }
            }
            if (totalGas >= 0) {
                return i;
            } else {
                totalGas = 0;
            }
        }

        return -1;
    }
}
