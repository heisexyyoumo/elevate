package com.humorous.elevate.aop;


import java.util.Arrays;

public class CalculatorTest {

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        test.test();
    }

    public void test() {
        Calculator calculator = new MathCalculator();
        Calculator proxy = CalculatorProxy.getCalculatorProxy(calculator);
        proxy.add(1,4);
        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
        //proxy.div(2,0);
    }
}
