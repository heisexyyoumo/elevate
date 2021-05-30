package com.humorous.elevate.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CountSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(new CountSubArray().countSubArray(arr, n));
    }

    List<List<Integer>> res;

    public int countSubArray(int[] arr, int n) {
        res = new LinkedList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            dfs(i, arr, n, 0, new LinkedList<>());
        }
        return res.size();
    }

    /**
     * 准备取下标index的值，将其和sum相加
     */
    private void dfs(int index, int[] arr, int n, int sum, LinkedList<Integer> list) {
        if (sum > 24) {
            return;
        }
        if (sum == 24) {
            if (!res.contains(list)) {
                res.add(new LinkedList<>(list));
            }
            return;
        }

        for (int i = index; i < n; i++) {
            sum += arr[i];
            list.addLast(arr[i]);
            dfs(i + 1, arr, n, sum, list);
            list.removeLast();
            sum -= arr[i];
        }
    }
}
