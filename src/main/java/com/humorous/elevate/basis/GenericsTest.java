package com.humorous.elevate.basis;

public class GenericsTest {

    public static void main(String[] args) {

    }

    public <T> void getObject(Class<T> c) throws IllegalAccessException, InstantiationException {
        T t = c.newInstance();
        System.out.println(t);
    }
}
