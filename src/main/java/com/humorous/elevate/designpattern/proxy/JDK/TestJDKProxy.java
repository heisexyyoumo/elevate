package com.humorous.elevate.designpattern.proxy.JDK;

import java.util.Date;

public class TestJDKProxy {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            SmsService smsService = (SmsService) JDKProxy.getProxy(new SmsServiceImpl());
//            System.out.println(smsService.getClass().getName());
//        }
//        smsService.send("java");
        System.out.println(System.currentTimeMillis());
        System.out.println(Long.MAX_VALUE);
    }
}
