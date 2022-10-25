package com.omar.data_structures.assignments.short_assignments;

import java.util.ArrayList;

/**
 * Recursion Practice Activity.
 *
 * @author Omar
 * @version 10.24.22
 */
public class RecursionActivity {

    public static void main(String[] args) {
       // System.out.print(starString(2) + "\n");
       // System.out.println(evenDigits(345));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(20);
        list.add(10);
        list.add(60);
        list.add(50);
        list.add(40);
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) < list.get(i - 1)) {
                int element = list.get(i);
                list.remove(i);
                list.add(0, element);
            }
        }
        System.out.println(list);
    }


    /**
     * @param n the number of stars to print.
     * @return a string of n stars.
     * @throws IllegalArgumentException if n is less than 0.
     */
    static String starString(int n) {
        if (n < 0) throw new IllegalArgumentException();
        if (n == 0) return "*";
        return starString(n - 1) + starString(n - 1);
    }


    /**
     * @param n number to check.
     * @return the number of even digits in n.
     */
    static int evenDigits(int n) {
        if (n == 0) return 0;
        if (n % 2 == 0)
            return n % 10 + 10 * evenDigits(n / 10);
        else
            return evenDigits(n / 10);
    }
}
