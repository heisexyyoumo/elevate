package com.humorous.elevate.designpattern.strategy;

/**
 * 要点1：必须将if else的代码，封装到不同的策略类中
 * 要点2：将选择哪种策略的逻辑给放到一个工厂类中去，选择策略的代码务必很简洁
 * 要点3：context可有可无，具体是看你的策略执行这块如果就一行代码调用，不需要context
 * 如果context中的策略执行逻辑较为复杂一点，context来封装策略类的执行逻辑
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        int discountStyle = 1;
        DiscountCalculateStrategy strategy = DiscountCalculateStrategyFactory
                .getDiscountCalculateStrategy(discountStyle);
        Context context = new Context();
        context.setStrategy(strategy);
        context.calculate();
    }
}
