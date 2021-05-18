package com.humorous.elevate.designpattern.proxy.JDK;

import java.lang.reflect.Proxy;

public class JDKProxy {

    public static Object getProxy(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("method-before");
                    Object result = method.invoke(object, args);
                    System.out.println("method-after");
                    return result;
                });
    }
}
