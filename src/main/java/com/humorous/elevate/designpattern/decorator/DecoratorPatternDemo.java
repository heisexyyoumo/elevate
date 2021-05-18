package com.humorous.elevate.designpattern.decorator;

/**
 * 假设我们手头已经有了一个类，可以执行一些功能
 * 但是我们还是希望对这个类的功能做一些增强，此时怎么办呢？基于已有的类的功能基础之上，再增强一些功能，可以做装饰
 * 装饰器模式有一些非常经典的实现
 * （1）比如java的io体系，可以一层包装一层，一层包装一层，外面的一层，都会对立面的一层进行功能的增强。
 * （2）还有就是spring的aop，aop这块可以基于动态代理的理念，装饰我们的目标对象，然后加入事务控制，日志打印之类的功能。
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decorator = new Decorator(component);
        decorator.execute();
    }

    public interface Component {

        void execute();

    }

    public static class ConcreteComponent implements Component {
        @Override
        public void execute() {
            System.out.println("执行基础功能");
        }
    }

    public static class Decorator implements Component {

        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void execute() {
            System.out.println("在执行基础功能之前，执行部分功能增强");
            component.execute();
            System.out.println("在执行基础功能之后，执行部分功能增强");
        }

    }
}
