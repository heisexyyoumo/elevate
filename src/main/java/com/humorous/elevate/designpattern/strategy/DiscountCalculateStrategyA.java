package com.humorous.elevate.designpattern.strategy;

public class DiscountCalculateStrategyA implements DiscountCalculateStrategy {
    @Override
    public void calculate() {
        System.out.println("执行优惠计价方式1的复杂业务逻辑");
    }
}
