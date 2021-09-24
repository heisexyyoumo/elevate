package com.humorous.elevate.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 55. 跳跃游戏
 * 动态规划+BFS
 */
public class CanJump {

    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new CanJump().canJump(nums));
    }

    // 贪心算法
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;
        for (int i = 0; i < n; i++) {
            if (i <= maxJump) {
                maxJump = Math.max(maxJump, i + nums[i]);
                if (maxJump >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        boolean[] memo = new boolean[nums.length];

        // 队列中存放nums数组的下标
        Queue<Integer> queue = new LinkedList();
        memo[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = 1; i <= nums[index]; i++) {
                int nextIndex = index + i;
                if (!queue.contains(nextIndex) && nextIndex < nums.length) {
                    queue.add(nextIndex);
                    memo[nextIndex] = true;
                }
            }
        }

        return memo[nums.length - 1];
    }
}
