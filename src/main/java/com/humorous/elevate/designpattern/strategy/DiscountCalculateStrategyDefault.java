package com.humorous.elevate.designpattern.strategy;

public class DiscountCalculateStrategyDefault implements DiscountCalculateStrategy {
    @Override
    public void calculate() {
        System.out.println("执行默认的优惠计价方式的复杂业务逻辑");
    }
}
