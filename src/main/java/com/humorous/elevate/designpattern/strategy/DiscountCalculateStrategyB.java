package com.humorous.elevate.designpattern.strategy;

public class DiscountCalculateStrategyB implements DiscountCalculateStrategy {
    @Override
    public void calculate() {
        System.out.println("执行优惠计价方式2的复杂业务逻辑");
    }
}
