package com.humorous.elevate.designpattern.strategy;

public class DiscountCalculateStrategyC implements DiscountCalculateStrategy {
    @Override
    public void calculate() {
        System.out.println("执行优惠计价方式3的复杂业务逻辑");
    }
}
