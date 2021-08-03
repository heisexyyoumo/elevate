package com.humorous.elevate.basis;

public class Father {


    private void say1() {
        System.out.println("father say");
    }

    void say2() {
        System.out.println("father say");
    }

    protected void say3() {
    }

    public void say4() {
        System.out.println("father say");
    }

    public static void main(String[] args) {
//        Father father = new Son();
//        father.say();
    }
}


class Son extends Father {
    public static void main(String[] args) {
    }
}
