package com.humorous.elevate.aop;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CalculatorProxy {

    public static Calculator getCalculatorProxy(Calculator calculator) {
        ClassLoader loader = calculator.getClass().getClassLoader();
        Class[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //System.out.println("动态代理");
                Object result = null;
                try {
                    System.out.println("正在执行的方法是：" + method.getName() + "参数列表是：" + Arrays.asList(objects));
                    result = method.invoke(calculator, objects);
                    System.out.println(method.getName() + "方法的结果是：" + result);
                } catch (Exception e) {
                    System.out.println("执行过程中，" + method.getName() + "出现异常,错误信息为：" + e.getCause());
                }
                return result;
            }
        };
        Object o = Proxy.newProxyInstance(loader, interfaces, h);
        return (Calculator) o;
    }
}
