package com.humorous.elevate.leetcode;

/**
 * leetcode 978. 最长湍流子数组
 */
public class MaxTurbulenceSize {

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(new MaxTurbulenceSize().maxTurbulenceSize(arr));
    }

    // memo[i]表示[0,i]中湍流子数组的最大长度
//    public int maxTurbulenceSize(int[] arr) {
//        int[] memo = new int[arr.length];
//        memo[0] = 1;
//
//        for (int i = 1; i < arr.length; i++) {
//            int res = memo[i - 1];
//            int j = i - 1;
//            while (j >= 0) {
//                if (j - 1 >= 0) {
//                    if ((arr[j + 1] - arr[j]) * (arr[j] - arr[j - 1]) < 0) {
//                        j--;
//                    } else {
//                        break;
//                    }
//                } else {
//                    break;
//                }
//            }
//            if (j == i - 1) {
//                res = Math.max(res, arr[i] == arr[j] ? 1 : 2);
//            } else {
//                res = Math.max(res, i - j + 1);
//            }
//            memo[i] = res;
//        }
//        return memo[arr.length - 1];
//    }


    // 滑动窗口来解决
    public int maxTurbulenceSize(int[] arr) {
        int l = 0, r = 0;
        int res = 1;

        while (l < arr.length) {
            if (r % 2 == 0) {
                if (r + 1 < arr.length && arr[r] < arr[r + 1]) {
                    r++;
                } else {
                    r++;
                    l = r;
                }
            } else {
                if (r + 1 < arr.length && arr[r] > arr[r + 1]) {
                    r++;
                } else {
                    r++;
                    l = r;
                }
            }

            if (r > l) {
                res = Math.max(res, r - l + 1);
            }
        }

        l = 0;
        r = 0;

        while (l < arr.length) {
            if (r % 2 == 0) {
                if (r + 1 < arr.length && arr[r] > arr[r + 1]) {
                    r++;
                } else {
                    r++;
                    l = r;
                }
            } else {
                if (r + 1 < arr.length && arr[r] < arr[r + 1]) {
                    r++;
                } else {
                    r++;
                    l = r;
                }
            }

            if (r > l) {
                res = Math.max(res, r - l + 1);
            }
        }

        return res;
    }

}
