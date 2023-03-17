package com.omar.data_structures.assignments.short_assignments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * List Practice
 *
 * @author Omar
 * @version 10.9.22
 */
public class CS145ArrayListPractice {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();

        myList.add("Four");
        myList.add("score");
        myList.add("and");
        myList.add("seven");
        myList.add("years");
        myList.add("ago.");
        System.out.print("Before: ");
        System.out.println(myList);

        swapPairs(myList);

        System.out.print("After:  ");
        System.out.println(myList);
        // Round 2 - Odd
        System.out.println();
        System.out.println("***********");
        System.out.println();

        myList.clear();

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        myList.add("6");
        myList.add("7");
        myList.add("8");
        myList.add("9");
        System.out.print("Before: ");
        System.out.println(myList);

        swapPairs(myList);

        System.out.print("After:  ");
        System.out.println(myList);
    }

    // Round 1 - Even
    private static void swapPairs(List<String> my_list) {
        if (my_list.size() % 2 == 0) {
            int x = 0;
            while (x < my_list.size()) {
                String tmp = my_list.get(x);
                my_list.set(x, my_list.get(x + 1));
                my_list.set(x + 1, tmp);
                x += 2;
            }
        } else {
            /*
             Calling the swapPairs() method recursively, this will
             make the last element of the list remain the same
             if the number of values in the list is odd
             */
            swapPairs(my_list.subList(0, my_list.size() - 1));
        }
    }

}
