package com.humorous.elevate.aop;

public class MathCalculator implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return j * i;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
