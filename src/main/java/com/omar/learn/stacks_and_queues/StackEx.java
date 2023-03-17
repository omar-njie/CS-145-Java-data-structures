package com.omar.learn.stacks_and_queues;

import java.util.Deque;
import java.util.Stack;

/**
 * @author Omar
 * @version 11/11/22
 */
public class StackEx {

    public static void main(String[] args) {

        // LIFO = Last-In First-Out
           // - Meaning that the most recently inserted element is the one that can be accessed first.
        String[] data = {"to", "be", "or", "not", "to", "be"};
        Stack<String> stack = new Stack<>();

        for (String str : data) {
            stack.push(str);
        }

        System.out.println("Stack: " + stack);
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(299);
        s.push(199);
        System.out.println(max(s));

        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        System.out.println("Sum: " + sum(s2));
    }

    static int max(Stack<Integer> s) {
        /*Stack<Integer> backup = new Stack<>();
        int max_value = s.peek();
        backup.push(max_value);

        while (!(s.isEmpty())) {
            int next = s.pop();
            backup.push(next);
            max_value = Math.max(max_value, next);
        }
        while (!(backup.isEmpty())) {
            s.push(backup.pop());
        }
        return max_value;*/
        // simplified version:
        int max_value = s.peek();
        while (!(s.isEmpty())) {
            max_value = Math.max(max_value, s.pop());
        }
        return max_value;
    }

    static int sum(Stack<Integer> s) {
        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        return sum;
    }


    // valid parentheses
    // https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}

