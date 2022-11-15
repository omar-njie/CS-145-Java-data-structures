package com.omar.learn.stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import static com.omar.learn.stacks_and_queues.QueueEx.makeRandomQueue;

/**
 * @author Omar
 * @version 11/12/22
 */
public class StacksAndQueues {

    public static void main(String[] args) {
        Queue<Integer> q = makeRandomQueue(10);
        Stack<Integer> s = new Stack<>();

        System.out.println("Queue: " + q);
        System.out.println("Stack: " + s);
        System.out.println();
        queueToStack(q, s);
        System.out.println("after queueToStack(q -> s):");
        System.out.println("Queue: " + q);
        System.out.println("Stack: " + s);
        stackToQueue(s, q);
        System.out.println();
        System.out.println("after stackToQueue(s -> q):");
        System.out.println("Stack: " + s);
        System.out.println("Queue: " + q);

        String expression = "5 2 4 * + 7 -";
        int x = solvePostFix(expression);
        System.out.println(x);
    }


    static void queueToStack(Queue<Integer> q, Stack<Integer> s) {
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
    }

    static void stackToQueue(Stack<Integer> s, Queue<Integer> q) {
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    static int solvePostFix(String exp) {
        Stack<Integer> s = new Stack<>();
        Scanner scan = new Scanner(exp);
        while(scan.hasNext()) {
            if (scan.hasNextInt()) {
                int temp = scan.nextInt();
                s.push(temp);
            } else {
                String temp = scan.next();
                if (temp.equals("+"))
                    s.push(s.pop() + s.pop());
                if (temp.equals("*") )
                    s.push(s.pop() * s.pop());
                if (temp.equals("-"))
                    s.push(-1 * s.pop() + s.pop());
                if (temp.equals("/") ) {
                    int t1 = s.pop();
                    int t2 = s.pop();
                    s.push(t2 / t1);
                }
            }
        }
       // if (s.size() != 1) throw new IllegalArgumentException();
        return s.pop();
    }
}

