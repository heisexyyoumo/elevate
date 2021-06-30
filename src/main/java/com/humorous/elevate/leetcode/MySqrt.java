package com.humorous.elevate.leetcode;

/**
 * 69. x 的平方根
 * 需要注意整型溢出问题
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(1518991037));

    }

    public int mySqrt(int x) {

        int l = 0;
        int r = x;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (Math.pow(m, 2) == x) {
                return m;
            } else if (Math.pow(m, 2) < x) {
                if (Math.pow(m + 1, 2) > x) {
                    return m;
                } else {
                    l = m + 1;
                }
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}


