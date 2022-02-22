package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 * 剑指 Offer II 113. 课程顺序
 */
public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }

        // 邻接表，便于快速读取数据
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        int[] inDegrees = new int[numCourses];
        for (int[] arr : prerequisites) {
            inDegrees[arr[0]]++;
            edges.get(arr[1]).add(arr[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int num = queue.poll();
                list.add(num);
                List<Integer> nextList = edges.get(num);
                for (int next : nextList) {
                    inDegrees[next]--;
                    if (inDegrees[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        if (list.size() != numCourses) {
            return new int[0];
        }
        for (int i = 0; i < numCourses; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
