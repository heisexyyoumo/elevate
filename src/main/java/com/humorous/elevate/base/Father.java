package com.humorous.elevate.base;

public class Father {

    public void say() {
        System.out.println("father say");
    }

    public static void main(String[] args) {
        Father father = new Son();
        father.say();
    }
}


class Son extends Father {
    @Override
    public void say() {
        System.out.println("son say");
    }
}
