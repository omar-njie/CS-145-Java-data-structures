package com.omar.data_structures.assignments.assignment_5;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * CS 145 - Part B
 * Card Array Master is a generic class usefull for you to test your
 * CardArrayList class.  At the beginning it is heavily commented out
 * but as you get more and more working, you can remove sections
 * to test various things out.
 * <p> This version is designed to test the Linked List version of the CardList </p>
 * @version 2.1
 */

public class CardListMasterTester {

    PrintStream SO = System.out;  // Lazy mode  enabled;
    CardList masterList1;

    public static void main(String[] args) {
        CardListMasterTester runMe = new CardListMasterTester();
        runMe.run();
    }

    public void run() {
        SO.println("****** Does the Linked List Work ******");
        stage1();
        stage2();
        stage3();
        stage4();
        stage5();
        stage6();
        stage7();
        stage8();
        stage9();
        stage10();
        stage11();
        stage12();
        stage13();
        SO.println();
        SO.println("****** Speed Tests ******");
        SO.println();
        stage101();
        stage102();
        stage103();
        stage104();
        stage105();

    }

    public void stage1() {
        // STAGE 1
        SO.println("Stage 1");
        // Can we add to a master list and print it out?
        //CardList masterList1 = new CardArrayList();
        masterList1 = new CardLinkedList();
        masterList1.add(new Card());
        masterList1.add(new Card(100));
        masterList1.add(new Card(200, 300, 400));
        SO.print("Initial list   : ");
        SO.println(masterList1);
    }

    public void stage2() {
        // STAGE 2
        SO.println();
        SO.println("Stage 2");
        // Can we add in other Locations?
        masterList1.add(0, new Card(1));
        SO.print("Add front      : ");
        SO.println(masterList1);
        masterList1.add(3, new Card(70, 80, 90));
        masterList1.add(3, new Card(500, 600, 700));
        SO.print("Added internal : ");
        SO.println(masterList1);

    }

    public void stage3() {
        // STAGE 3
        SO.println();
        SO.println("Stage 3");
        // can we add more cards

        masterList1.add(2, new Card(100));
        masterList1.add(4, new Card(200));
        masterList1.add(6, new Card(300));
        masterList1.add(8, new Card(399, 400, 401));
        SO.print("After More (10): ");
        SO.println(masterList1);
    }

    public void stage4() {
        // STAGE 4
        SO.println();
        SO.println("Stage 3");
        // Can we Remove the end value
        masterList1.remove();
        SO.print("After A Remove : ");
        SO.println(masterList1);
    }

    public void stage5() {
        // STAGE 5
        SO.println();
        SO.println("Stage 5");
        // Does remove return the removed value?

        SO.println("Returned Card  : ");
        SO.print("(399,400,401)? : ");
        SO.println(masterList1.remove());
        SO.print("After Remove #2: ");
        SO.println(masterList1);
    }

    public void stage6() {
        // STAGE 6
        SO.println();
        SO.println("Stage 6");
        // Did it remove from the middle
        // And return the value removed?
        Card tmp = masterList1.remove(2);
        SO.println("Remove item #2 : ");
        SO.print("(100,100,100) ?: ");
        SO.println(tmp);
        SO.print("List afterward : ");
        SO.println(masterList1);
    }

    public void stage7() {
        // STAGE 7
        SO.println();
        SO.println("Stage 7");
        // Did it remove from the front
        // And return the value removed?
        Card tmp = masterList1.remove(0);
        SO.println("Remove item #0 : ");
        SO.print("Should be 1/1/1: ");
        SO.println(tmp);
        SO.print("List afterward : ");
        SO.println(masterList1);
    }

    public void stage8() {
        // STAGE 8
        SO.println();
        SO.println("Stage 8");
        // Did get work correctly?
        SO.print("Get Values     : ");
        SO.println(masterList1.get(1) + " : " + masterList1.get(3));
        masterList1.get(1).weaken();
        masterList1.get(3).boost();
        SO.print("Altered Values : ");
        SO.println(masterList1.get(1) + " : " + masterList1.get(3));

        try {
            masterList1.get(99);
            masterList1.get(0);
            SO.println("THIS IS AN ERROR in stage 8");
        } catch (Exception e) {
            SO.println("Exception found: " + e);
        }

    }


    // STAGE 9
    // IndexOF
    public void stage9() {
        SO.println();
        SO.println("Stage 9");
        SO.print("Found Success(4): ");
        SO.println(masterList1.indexOf(new Card(300)));
        SO.print("Found Success(3): ");
        SO.println(masterList1.indexOf(new Card(505, 600, 700)));
        SO.print("Found Failed(-1): ");
        SO.println(masterList1.indexOf(new Card(1000)));
    }

    public void stage10() {
        // STAGE 10
        SO.println();
        SO.println("Stage 10");
        // Does shuffle work?
        SO.print("Before shuffle : ");
        SO.println(masterList1);
        masterList1.shuffle();
        SO.print("Post shuffle 1 : ");
        SO.println(masterList1);
        masterList1.shuffle();
        SO.print("Post shuffle 2 : ");
        SO.println(masterList1);
    }

    public void stage11() {
        // STAGE 11
        SO.println();
        SO.println("Stage 11");
        // Does Clear Work?
        masterList1.clear();
        SO.print("After Clear    : ");
        SO.println(masterList1);
    }

    public void stage12() {
        // STAGE 12
        SO.println();
        SO.println("Stage 12");
        // Create a large list
        // And check that sort works.

        for (int i = 0; i < 25; i++) {
            masterList1.add(new Card());
        }
        SO.print("Before Sorted  : ");
        SO.println(masterList1);
        masterList1.sort();
        SO.print("Success Sorted : ");
        SO.println(masterList1);
        if (testSort())
            SO.print("Success Sorted : Correct\n");
        else
            SO.print("Failed  Sorted :  InCorrect");
    }

    private boolean testSort() {
        for (int j = 0; j < masterList1.size() - 1; j++)
            if (masterList1.get(j).compareTo(masterList1.get(j + 1)) > 0)
                return false;
        return true;
    }

    public void stage13() {
        // STAGE 13
        SO.println();
        SO.println("Stage 13");
        // Create a list
        // And check that reverse works.
        masterList1.reverse();
        SO.print("Reversed Set  : ");
        SO.println(masterList1);
        if (testReverse())
            SO.print("Success Reversed : Correct\n");
        else
            SO.print("Failed  Reversed :  InCorrect");
    }

    private boolean testReverse() {
        for (int j = 0; j < masterList1.size() - 1; j++)
            if (masterList1.get(j).compareTo(masterList1.get(j + 1)) < 0)
                return false;
        return true;
    }

    //****************************************************************
    // SPEED TESTING
    //****************************************************************


    public void stage101() {
        // STAGE 12
        SO.println("Stage 101");
        // Create a large list and Compare the Two

        CardList masterLL = new CardLinkedList();
        CardList masterAL = new CardArrayList();

        long timeA, timeB, timeC;

        timeA = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            Card C = new Card();
            masterAL.add(C);
        }
        timeB = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Card C = new Card();
            masterLL.add(C);
        }
        timeC = System.currentTimeMillis();

        timeA = timeB - timeA;
        timeB = timeC - timeB;

        SO.println("Adding 10000 elements to a List, to the back each time.");
        SO.printf("Time to fill the Array List  = %d milliseconds%n", timeA);
        SO.printf("Time to fill the Linked List = %d milliseconds%n", timeB);
        SO.println();
    }

    public void stage102() {
        // STAGE 13
        SO.println("Stage 102");
        // Create a large list and Compare the Two

        CardList masterLL = new CardLinkedList();
        CardList masterAL = new CardArrayList();

        long timeA, timeB, timeC;

        timeA = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            Card C = new Card();
            masterAL.add(0, C);
        }
        timeB = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Card C = new Card();
            masterLL.add(0, C);
        }
        timeC = System.currentTimeMillis();

        timeA = timeB - timeA;
        timeB = timeC - timeB;

        SO.println("Adding 10000 elements to a List, to the front each time.");
        SO.printf("Time to fill the Array List  = %d milliseconds%n", timeA);
        SO.printf("Time to fill the Linked List = %d milliseconds%n", timeB);
        SO.println();
    }

    public void stage103() {
        // STAGE 14
        SO.println("Stage 103");
        // Create a large list and Compare the Two

        CardList masterLL = new CardLinkedList();
        CardList masterAL = new CardArrayList();

        for (int i = 0; i < 10000; i++) {
            Card C = new Card();
            masterLL.add(C);
            masterAL.add(C);
        }

        long timeA, timeB, timeC;

        timeA = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            masterAL.remove(0);
        }
        timeB = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            masterLL.remove(0);
        }
        timeC = System.currentTimeMillis();

        timeA = timeB - timeA;
        timeB = timeC - timeB;

        SO.println("Removing 10000 elements to a List, always from the front.");
        SO.printf("Time to empty the Array List  = %d milliseconds%n", timeA);
        SO.printf("Time to empty the Linked List = %d milliseconds%n", timeB);
        SO.println();
    }

    public void stage104() {
        // STAGE 15
        SO.println("Stage 104");
        // Create a large list and Compare the Two

        CardList masterLL = new CardLinkedList();
        CardList masterAL = new CardArrayList();

        for (int i = 0; i < 10000; i++) {
            Card C = new Card();
            masterLL.add(C);
            masterAL.add(C);
        }

        long timeA, timeB, timeC;

        timeA = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            masterAL.remove();
        }
        timeB = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            masterLL.remove();
        }
        timeC = System.currentTimeMillis();

        timeA = timeB - timeA;
        timeB = timeC - timeB;

        SO.println("Removing 10000 elements to a List, always from the back.");
        SO.printf("Time to empty the Array List  = %d milliseconds%n", timeA);
        SO.printf("Time to empty the Linked List = %d milliseconds%n", timeB);
        SO.println();
    }

    public void stage105() {
        // STAGE 16
        SO.println("Stage 105");
        // Adding to the middle of a List

        CardList masterLL = new CardLinkedList();
        CardList masterAL = new CardArrayList();

        for (int i = 0; i < 10000; i++) {
            Card C = new Card();
            masterLL.add(C);
            masterAL.add(C);
        }

        long timeA, timeB, timeC;

        timeA = System.currentTimeMillis();

        for (int i = 0; i < 5000; i++) {
            masterAL.add(5000, new Card());
        }
        timeB = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            masterAL.add(5000, new Card());
        }
        timeC = System.currentTimeMillis();

        timeA = timeB - timeA;
        timeB = timeC - timeB;

        SO.println("Time to add 5000 elements to a 10000 list, always in the middle");
        SO.printf("Time to empty the Array List  = %d milliseconds%n", timeA);
        SO.printf("Time to empty the Linked List = %d milliseconds%n", timeB);

    }


}