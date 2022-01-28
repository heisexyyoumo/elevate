package com.humorous.elevate.basis;

public class PrintAddress {
    static String DEFAULT_ADDRESS = "广东省广州市天河区创意软件园";
    String currentAddress;

    public PrintAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public void print() {
        System.out.println(currentAddress);
    }

    public static void defaultPrint() {
        System.out.println("默认公司地址：" + DEFAULT_ADDRESS);
    }
}
