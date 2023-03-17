package com.omar.learn.trees.binary_search_tree;

import java.util.Scanner;

/**
 * @author Omar
 * @version 11/29/22
 */
public class IntSearchTreeClient {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IntSearchTree numbers = new IntSearchTree();
        System.out.print("Next int (0 to quit)? ");
        int number = in.nextInt();
        while (number != 0) {
            numbers.add(number);
            System.out.print("Next int (0 to quit)? ");
            number = in.nextInt();
        }
        System.out.println();
        System.out.println("Tree structure:");
        numbers.printSideways();
        System.out.println("Sorted list:");
        numbers.print();
        System.out.println();
        System.out.println(numbers.countLeftNodes());
        System.out.println(numbers.contains(5));
    }
}
