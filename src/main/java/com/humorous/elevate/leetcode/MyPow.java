package com.humorous.elevate.leetcode;

/**
 * 50. Pow(x, n)
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2.0, 10));
    }


    public double myPow(double x, int n) {
        double res = (double) 1;
        if (n > 0) {
            res = absPow(x, n);
        } else if (n < 0) {
            res = absPow(x, -n);
            res = 1 / res;
        }
        return res;
    }

    public double absPow(double x, int n) {
        if (n == 0)
            return (double) 1;
        if (n == 1)
            return x;

        double t = absPow(x, n / 2);
        return n % 2 == 0 ? t * t : t * t * x;
    }
}
