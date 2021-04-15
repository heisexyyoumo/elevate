package com.humorous.elevate.algorithm;

/**
 * bitmap--解决海量整数中是否存在某个值
 * 使用位数代表数的大小，bit中存储0或1来标识该整数是否存在
 */
public class BitMap {
    private byte[] bytes;
    private int initSize;

    public BitMap(int size) {
        if (size <= 0) {
            return;
        }
        initSize = size / 8 + 1;
        bytes = new byte[initSize];
    }

    public void set(int number) {
        int index = number >> 3; // 等价于 number/8
        int position = number & 0x07; // 等价于number%8
        bytes[index] |= 1 << position;
    }

    public boolean contains(int number) {
        int index = number >> 3; // 等价于 number/8
        int position = number & 0x07; // 等价于number%8
        return (bytes[index] & (1 << position)) != 0;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(32); // 存储0-31的数字
        bitMap.set(30);
        bitMap.set(0);
        System.out.println(bitMap.contains(0));
        System.out.println(bitMap.contains(9));

    }
}
