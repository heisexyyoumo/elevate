package com.humorous.elevate.controller;

import com.humorous.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello123")
    public String sayHello() {
        String s = helloService.sayHello("张三");
        return s;
    }
}
