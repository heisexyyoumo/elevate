package com.humorous.elevate.basis;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {

    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(null, null);
//        map.put(null, null);
//        Map<Integer, Integer> map1 = new LinkedHashMap<>();
//        map1.put(null, null);
//        map1.put(null, null);
//
//        Set<Integer> set = new HashSet<>();
//        set.add(null);
//        set.add(null);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (Integer integer : list) {
            System.out.println(integer);
        }

        list.forEach(e -> System.out.println(e));
    }
}
