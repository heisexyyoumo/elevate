package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. 课程表 II
 */
public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[]{};
        }
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();

        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        // 填充入度表和邻接表
        for (int[] array : prerequisites) {
            inDegrees[array[0]]++;
            adjacency.get(array[1]).add(array[0]);
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            result.add(pre);
            List<Integer> list = adjacency.get(pre);
            for (int cur : list) {
                if (--inDegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        if (result.size() < numCourses) {
            return new int[]{};
        } else {
            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }
    }
}
