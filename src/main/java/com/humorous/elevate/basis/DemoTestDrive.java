package com.humorous.elevate.basis;

public class DemoTestDrive {
    public static void main(String[] args) {
        PrintAddress addressA = new PrintAddress("当前公司A地址：" + "广州天河北路");
        PrintAddress addressB = new PrintAddress("当前公司B地址：" + "广州越秀区");
        addressA.print();
        addressB.DEFAULT_ADDRESS = "广东省广州市华夏路10富力中心";
        addressA.defaultPrint();
        addressB.print();
        addressB.defaultPrint();
        BaseTest t = new BaseTest();
    }
}
