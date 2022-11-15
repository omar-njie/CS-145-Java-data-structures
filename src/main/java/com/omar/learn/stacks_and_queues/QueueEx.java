package com.omar.learn.stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class QueueEx {

    public static void main(String[] args) {

        // FIFO = First-In First-Out
            // - Meaning that the first inserted element is the first one that can be accessed first.

        String[] data = {"to", "be", "or", "not", "to", "be"};
        Queue<String> q_str = new LinkedList<>();

        for (String str : data) {
            q_str.add(str);
        }
        // Collections.addAll(q_str, data);

        System.out.println("Queue: " + q_str);
        System.out.println("Size: " + q_str.size());
        System.out.println("Peek: " + q_str.peek());
        while (!q_str.isEmpty()) {
            System.out.print(q_str.remove() + " ");
        }
        System.out.println();

        Queue<Integer> q = makeRandomQueue(10);
        System.out.println("Queue: " + q);

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(1);
        q2.add(2);
        System.out.println("Sum: " + sum(q2));

        // add = offer
        // remove = poll
        // element = peek
        Queue<String> q3 = new LinkedList<>();
        q3.offer("Omar");
        q3.offer("Tim");
        q3.offer("John");
        q3.offer("Bob");
        System.out.println(q3.peek());

    }

    static Queue<Integer> makeRandomQueue(int size) {
        Queue<Integer> q = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < size; i++)
            q.add(r.nextInt(100));
        return q;
    }

    static int sum(Queue<Integer> q) {
        int sum = 0;
        while (!q.isEmpty()) {
            sum += q.remove();
        }
        return sum;
    }
}
