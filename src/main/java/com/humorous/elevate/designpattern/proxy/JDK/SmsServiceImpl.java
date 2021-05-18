package com.humorous.elevate.designpattern.proxy.JDK;

public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println(message);
        return message;
    }
}
