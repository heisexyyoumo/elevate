package com.humorous.elevate.leetcode;

import java.lang.ref.WeakReference;

public class CanCompleteCircuit {


    public static void main(String[] args) {
//        int[] gas = {1, 2, 3, 4, 5};
//        int[] gas = {2, 3, 4};
////        int[] cost = {3, 4, 5, 1, 2};
//        int[] cost = {3, 4, 3};
//        System.out.println(new CanCompleteCircuit().canCompleteCircuit(gas, cost));
//        Integer number = new Integer(1);
//        WeakReference<Integer> reference = new WeakReference<>(new Integer(1));
//        Map<Reference<Integer>, String> map = new HashMap<>();
//        map.put(reference, "test");
//        Set<Reference<Integer>> references = map.keySet();
//        for (Reference<Integer> reference1 : references) {
//            System.out.println(reference1.get());
//            System.out.println(map.get(reference1));
//            System.out.println(reference.get());
//        }
//
//        System.out.println(reference.get());

//        number = null;
//        System.out.println("==============gc=================");
//        System.gc();
//        Set<Map.Entry<Reference<Integer>, String>> entries = map.entrySet();
//        for (Map.Entry<Reference<Integer>, String> entry : entries) {
//            System.out.println(entry.getKey().get());
//            System.out.println(entry.getValue());
//            System.out.println(reference.get());
//        }
//        System.out.println(reference.get());

//
        Object o1 = new Object();
//        Object o2 = o1;
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
//        System.out.println(o2);
        System.out.println(weakReference.get());
        o1 = null;
        System.gc();
        System.out.println(o1);
//        System.out.println(o2);
        System.out.println(weakReference.get());

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int temp = i;
            totalGas = gas[i] - cost[(i + 1) % n];
            while (totalGas >= 0) {
                temp++;
                if (temp % n == i) {
                    break;
                }
                totalGas = totalGas + gas[temp % n] - cost[(temp + 1) % n];
                if (totalGas < 0) {
                    break;
                }
            }
            if (totalGas >= 0) {
                return i;
            } else {
                totalGas = 0;
            }
        }

        return -1;
    }
}
