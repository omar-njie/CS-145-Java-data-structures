package com.omar.learn.trees.binary_search_tree.generic_format;

import java.util.Scanner;

/**
 * This program uses the SearchTree class
 * to construct a binary search tree of integers and strings
 * and print out each.
 *
 * @author Omar
 * @version 11/29/22
 */
public class SearchTreeClient {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SearchTree<String> names = new SearchTree<>();
        System.out.print("Next name (blank to quit)? ");
        String name = in.nextLine();
        while (!name.equals("")) {
            names.add(name);
            System.out.print("Next name (blank to quit)? ");
            name = in.nextLine();
        }
        System.out.println();
        System.out.println("Alphabetical list:");
        names.print();
        System.out.println("Tree structure:");
        names.printSideways();
        System.out.println();

        SearchTree<Integer> numbers = new SearchTree<>();
        System.out.print("Next int (0 to quit)? ");
        int number = in.nextInt();
        while (number != 0) {
            numbers.add(number);
            System.out.print("Next int (0 to quit)? ");
            number = in.nextInt();
        }
        System.out.println();
        System.out.println("Sorted list:");
        numbers.print();
        System.out.println("Tree structure:");
        numbers.printSideways();
        System.out.println();

    }
}
