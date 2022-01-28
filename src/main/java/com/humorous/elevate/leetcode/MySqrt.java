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


    /**
     * 使用二分查找
     */
    public int mySqrt2(int x) {
        // 从[0,x/2]之间找最后的一个数的平方小于等于x
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int l = 1;
        int r = x / 2;
        while (l < r) {
            int m = l + (r - l + 1) / 2;

            // 预防整型溢出
            if (m <= x / m) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

}


