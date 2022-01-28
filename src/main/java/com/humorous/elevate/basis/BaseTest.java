package com.humorous.elevate.basis;

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
//        BaseTest t = new BaseTest();
//        t.STATIC_MSG = "modify";
//        BaseTest.StaticClass.print();
//        String s = new StringBuilder().toString();
//        System.out.println(s);
//        BaseTest baseTest = new BaseTest(3);
//        System.out.println(baseTest.size);

        long a = -2147483648, b = 2147483647;
        long res = (long) Math.abs(a - b);
        System.out.println(res);
        System.out.println(Math.abs(a - b));

    }

}
