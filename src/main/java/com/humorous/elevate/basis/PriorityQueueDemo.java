package com.humorous.elevate.basis;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(1);
        queue.add(2);
        queue.add(4);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
