package com.humorous.elevate.designpattern.proxy.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class CglibProxy {
    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setUseCache(false);
        enhancer.setCallback((MethodInterceptor) (o, method, args, methodProxy) -> {
            System.out.println("method-before");
            Object result = methodProxy.invokeSuper(o, args);
            System.out.println("method-after");
            return result;
        });
        return enhancer.create();
    }
}
