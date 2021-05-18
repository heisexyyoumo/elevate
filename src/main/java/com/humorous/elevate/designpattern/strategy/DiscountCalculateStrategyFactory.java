package com.humorous.elevate.designpattern.strategy;

public class DiscountCalculateStrategyFactory {
    public static DiscountCalculateStrategy getDiscountCalculateStrategy(int discountStyle) {
        if (discountStyle == 1) {
            return new DiscountCalculateStrategyA();
        } else if (discountStyle == 2) {
            return new DiscountCalculateStrategyB();
        } else if (discountStyle == 3) {
            return new DiscountCalculateStrategyC();
        } else {
            return new DiscountCalculateStrategyDefault();
        }
    }
}