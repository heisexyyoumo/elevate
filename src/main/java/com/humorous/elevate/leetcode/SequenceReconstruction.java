package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * 剑指 Offer II 115. 重建序列
 */
public class SequenceReconstruction {


    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs.size() == 0) {
            return false;
        }


        // 邻接表
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        // 入度表
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        for (List<Integer> list : seqs) {
            for (Integer num : list) {
                map.put(num, new HashSet<>());
                inDegreeMap.put(num, 0);
            }
        }

        for (List<Integer> list : seqs) {
            int len = list.size();
            for (int i = 0; i < len - 1; i++) {
                int first = list.get(i);
                int second = list.get(i + 1);
                if (!map.get(first).contains(second)) {
                    map.get(first).add(second);
                    Integer var = inDegreeMap.get(second);
                    inDegreeMap.put(second, var + 1);

                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : inDegreeMap.keySet()) {
            if (inDegreeMap.get(key) == 0) {
                queue.add(key);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }
            while (size-- > 0) {
                int num = queue.poll();
                res.add(num);
                for (int next : map.get(num)) {
                    Integer var = inDegreeMap.get(next);
                    inDegreeMap.put(next, var - 1);
                    if (inDegreeMap.get(next) == 0) {
                        queue.add(next);
                    }
                }
            }

        }
        if (res.size() != map.size()) {
            return false;
        }
        if (res.size() != org.length) {
            return false;
        }
        for (int i = 0; i < org.length; i++) {
            if (res.get(i) != org[i]) {
                return false;
            }
        }

        return true;
    }
}
