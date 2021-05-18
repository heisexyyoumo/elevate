package com.humorous.elevate.designpattern.proxy.Cglib;

public class EmailService {

    String send(String email) {
        System.out.println(email);
        return email;
    }
}
