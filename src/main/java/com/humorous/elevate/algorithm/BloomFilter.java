package com.humorous.elevate.algorithm;

/**
 * 布隆过滤器，调用三种hash算法
 */
public class BloomFilter {
    private final int arraySize;
    private final int[] array;

    public BloomFilter(int arraySize) {
        this.arraySize = arraySize;
        array = new int[arraySize];
    }

    public void add(String key) {
        int first = hashcode_1(key);
        int second = hashcode_2(key);
        int third = hashcode_3(key);
        array[first % arraySize] = 1;
        array[second % arraySize] = 1;
        array[third % arraySize] = 1;
    }

    public boolean contains(String key) {
        int first = hashcode_1(key);
        int second = hashcode_2(key);
        int third = hashcode_3(key);
        int firstVal = array[first % arraySize];
        if (firstVal == 0) {
            return false;
        }
        int secondVal = array[second % arraySize];
        if (secondVal == 0) {
            return false;
        }
        int thirdVal = array[third % arraySize];
        return thirdVal != 0;
    }

    private int hashcode_1(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    private int hashcode_2(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash);
    }

    private int hashcode_3(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash);
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(10000000);
        for (int i = 0; i < 10000000; i++) {
            bloomFilter.add(i + "");
        }
        System.out.println(bloomFilter.contains(1 + ""));
        System.out.println(bloomFilter.contains(999999 + ""));
        System.out.println(bloomFilter.contains(400230340 + ""));
    }
}
