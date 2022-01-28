package com.humorous.elevate.basis;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("运行结果：");
//        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        //for
//        Long forBegin = System.currentTimeMillis();
//        for (Integer number : numberList) {
//            //System.out.println(String.format("For The Current Thread's ID is %d and output number %d ",Thread.currentThread().getId(),number));
//            Thread.sleep(1000);
//        }
//        System.out.println(String.format("For execute time cost %d ms", System.currentTimeMillis() - forBegin));
//        System.out.println("\r");
//        // stream method
//        Long streamBegin = System.currentTimeMillis();
//        numberList.stream().forEach(number -> {
//            //System.out.println(String.format("Stream The Current Thread's ID is %d and output number %d ",Thread.currentThread().getId(),number));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(String.format("Stream execute time cost %d ms", System.currentTimeMillis() - streamBegin));
//        System.out.println("\r");
//        // parallelStream method
//        Long parallelStreamBegin = System.currentTimeMillis();
//        numberList.parallelStream().forEach(number -> {
//            //System.out.println(String.format("ParallelStream The Current Thread's ID is %d and output number %d ",Thread.currentThread().getId(),number));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(String.format("ParallelStream execute time cost %d ms", System.currentTimeMillis() - parallelStreamBegin));
//        System.out.println("\r");
//        // parallelStream method
//        Long parallelStreamForEachOrderBegin = System.currentTimeMillis();
//        numberList.parallelStream().forEachOrdered(number -> {
//            //System.out.println(String.format("ParallelStream forEachOrdered The Current Thread's ID is %d and output number %d ",Thread.currentThread().getId(),number));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(String.format("ParallelStream forEachOrdered execute time cost %d ms", System.currentTimeMillis() - parallelStreamForEachOrderBegin));
//        System.out.println("\r");

//        String task1 = "1,2,4,6,7";
//        String task2 = "1,2,4,7,9";
//        String task3 = "3,5";
//        String task4 = null;
//        List<String> list = new ArrayList<>();
//        list.add(task1);
//        list.add(task2);
//        list.add(task3);
//        list.add(task4);
//
//        List<String> collect = list.stream().map(e -> {
//            if (StringUtils.isEmpty(e)) {
//                return new ArrayList<String>();
//            } else {
//                return new ArrayList<String>(Arrays.asList(e.split(",")));
//            }
//        }).flatMap(Collection::stream).distinct().collect(Collectors.toList());
//
//        List<String> son = new ArrayList<>();
//        son.add("99");
//        son.add("9");
//
//        System.out.println(collect.containsAll(son));

        String url = "\\\\data\\fa";
        String replace = url.replace("\\", "/");
        System.out.println(replace);
    }
}
