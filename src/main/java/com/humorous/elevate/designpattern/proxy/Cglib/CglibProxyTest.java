package com.humorous.elevate.designpattern.proxy.Cglib;

public class CglibProxyTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            EmailService emailService = (EmailService) CglibProxy.getProxy(EmailService.class);
            System.out.println(emailService.getClass().getName());
        }
//        emailService.send("hello");
    }
}
