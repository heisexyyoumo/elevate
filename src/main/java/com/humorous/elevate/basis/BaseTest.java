package com.humorous.elevate.basis;

import java.util.Arrays;

/**
 * 基础
 */
public class BaseTest {

    static String STATIC_MSG = "static msg";

    int size;

    public BaseTest() {

    }

    public BaseTest(int size) {
        this.size = size;
    }

    public static class StaticClass {
        public static void print() {
            System.out.println(BaseTest.STATIC_MSG);
        }
    }

    public static class NonStaticClass {

        public static void print() {
            System.out.println(BaseTest.STATIC_MSG);
        }
    }

    public static void main(String[] args) {
//        String[] arr = {"a", "aa", "b", "bc", "dc"};
//        Arrays.sort(arr, (o1, o2) -> {
//            return o2.length() - o1.length();
//        });
//
//        for (String str : arr) {
//            System.out.println(str);
//        }
        int a = 1;
        int max = Math.max(a, a + 1);
        System.out.println(max);
    }

    static class A {
        public A() {

        }

        final int a() {
            return 1;
        }
    }

}
