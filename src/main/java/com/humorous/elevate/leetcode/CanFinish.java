package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * 拓扑排序+入度表BFS
 * 通过拓扑排序判断图是否是有向无环图(DAG)
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 入度表
        int[] indegrees = new int[numCourses];
        // 邻接表
        List<List<Integer>> adjacency = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }


        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }


        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }

        return numCourses == 0;
    }

}
