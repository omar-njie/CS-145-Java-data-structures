package com.omar.learn.stacks_and_queues;

import java.util.*;

/**
 * @author Omar
 * @version 11/14/22
 */
public class PriorityQueueEx {

    public static void main(String[] args) {

        // Priority Queue = A FIFO data structure that serves elements
        //                   with the highest priority first.
        //                   before the elements with lower priority.

        Queue<Double> q = new PriorityQueue<>(Collections.reverseOrder());

        q.offer(3.2);
        q.offer(2.8);
        q.offer(1.1);
        q.offer(3.5);
        q.offer(4.0);

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
