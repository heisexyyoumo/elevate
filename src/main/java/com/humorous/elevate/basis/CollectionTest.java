package com.humorous.elevate.basis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTest {

    public static void main(String[] args) {
        String[] strs = {"1371", "1372", "1375", "1376", "1378"};

        List<String> str1 = new ArrayList<>(Arrays.asList(strs));
//        str1.add("1371");
//        str1.add("1372");
//        str1.add("1375");
//        str1.add("1376");
//        str1.add("1378");
//        str1.add("1379");

        List<String> str2 = new ArrayList<>();
        str2.add("1371");
        str2.add("1372");
        str2.add("1375");

        str1.removeAll(str2);
        str1.forEach(System.out::println);


    }
}
