package com.humorous.elevate.basis;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        int[] freq = new int[256];
//        freq['a'] = 1;
//        System.out.println(freq[97]);
//
//        String a = "ahsdhahhhg";
//        String s = a.substring(3, -1);
//        System.out.println();
//        System.out.println(1);
//        byte b = 1;
//        int i=b;
//        long l=b;
//        float f=b;
//        double d=b;
//        int[][] test = new int[0][0];
//        StringBuilder sb = new StringBuilder();
//        sb.append(1);
//        System.out.println(sb.toString());

        // 按行读取配置文件:
        List<String> props = Arrays.asList("profile=native", "debug=true", "logging=warn", "interval=500");
        Map<String, String> map = props.stream()
                // 把k=v转换为Map[k]=v:
                .map(kv -> {
                    String[] ss = kv.split("\\=", 2);
                    return Collections.singletonMap(ss[0], ss[1]);
                })
                // 把所有Map聚合到一个Map:
                .reduce(new HashMap<String, String>(), (m, kv) -> {
                    m.putAll(kv);
                    return m;
                });
        // 打印结果:
        map.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }
}
