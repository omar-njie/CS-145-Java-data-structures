package com.omar.data_structures.assignments.assignment_4;

/**
 * CS 145
 * <p>
 * Card Array Master is a generic class usefull for you to test your
 * CardArrayList class.   At the beginning it is heavily commented out
 * but as you get more and more working, you can remove sections
 * to test various things out.
 * <p>
 * Remove the /***   *** / around each section to test it.
 *
 * @author Michael A. Wood
 * @version 3.1 - RPS Card Style
 */

import java.io.PrintStream;

public class CardArrayMaster {

    /*public static void main(String[] args) {
        PrintStream SO = System.out;  // Lazy mode  enabled;

        SO.println("Stage 0");
        SO.println();
        // STAGE 0
        // Does your card work
        try {
            new Card(-100, 0, 0);
            new Card(1001, 1, 1);
            System.out.println("ERROR");
            System.exit(-1);
        } catch (Exception e) {
            SO.println("Card Errors Caught, Good work");
        }


        // STAGE 1
        // Can we add to a master list and print it out?

         SO.println();SO.println("Stage 1");SO.println();
         CardList masterList1 = new CardArrayList();
         masterList1.add(new Card());
         masterList1.add(new Card(200, 300, 500));
         masterList1.add(new Card(5));
         masterList1.add(new Card(600,100, 600));
         SO.print("Initial list   : ");
         SO.println(masterList1);




        // STAGE 2
        // Can we add a premium card?
         SO.println();SO.println("Stage 2");SO.println();
         masterList1.add(new PremiumCard(25, 40, 55));
         SO.print("Premium Card   : ");
         SO.println(masterList1);


        // STAGE 3
        // Can we add cards in the middle?
         SO.println();SO.println("Stage 3");SO.println();
         masterList1.add(1, new Card(2,4,10));
         masterList1.add(1, new Card(5,5,9));
         SO.print("Added internal : ");
         SO.println(masterList1);


        // STAGE 4
        // can we add more cards and make it expand?
         SO.println();SO.println("Stage 4");SO.println();
         masterList1.add(new Card(6,7,8));
         masterList1.add(new Card(7,8,9));
         masterList1.add(new Card(8,10,12));
         masterList1.add(new Card(9, 90, 900));
         masterList1.add(new Card(10, 100, 100));
         masterList1.add(new Card(11, 121, 800));
         masterList1.add(new Card(12, 122, 210));
         SO.print("After Expand   : ");
         SO.println(masterList1);


        // STAGE 5
        // Can we Remove the end value
         SO.println();SO.println("Stage 5");SO.println();
         masterList1.remove();
         SO.print("After Remove   : ");
         SO.println(masterList1);

         // STAGE 6
         // Does remove return the removed value?
         SO.println();SO.println("Stage 6");SO.println();
         SO.print("Removed value  : ");
         SO.println(masterList1.remove() );
         SO.print("List afterward : ");
         SO.println(masterList1);


        // STAGE 7
        // Did it remove from the middle
        // And return the value removed?
         SO.println();
         SO.println("Stage 7");SO.println();
         Card tmp = masterList1.remove(2);
         SO.print("Removed value  : ");
         SO.println(tmp);
         SO.print("List afterward : ");
         SO.println(masterList1);


        // STAGE 8
        // Did get work correctly?
         SO.println();SO.println("Stage 8");SO.println();
         SO.print("Checking equals: ");
         if (masterList1.get(9).equals(new Card(9,90,900)))
         SO.println("Success");   else SO.println("Failure");

         SO.print("Get Values     : ");
         SO.println(masterList1.get(2) + " : " + masterList1.get(4) );
         masterList1.get(2).boost();
         masterList1.get(4).weaken();
         SO.print("Altered Values : ");
         SO.println(masterList1.get(2) + " : " + masterList1.get(4) );


        // STAGE 9
        // IndexOF
         SO.println();SO.println("Stage 9");SO.println();
         SO.print("Found Success(3): ");
         SO.println(masterList1.indexOf(new Card(5)));
         SO.print("Found Success(2): ");
         SO.println(masterList1.indexOf(new Card(205,300,500)));
         SO.print("Found Failed(-1): ");
         SO.println(masterList1.indexOf(new Card(7,7,8)));


        // STAGE 10
        // Does shuffle work?
         SO.println();SO.println("Stage 10");SO.println();
         SO.print("Before shuffle : ");
         SO.println(masterList1);
         masterList1.shuffle();
         SO.print("Post shuffle 1 : ");
         SO.println(masterList1);
         masterList1.shuffle();
         SO.print("Post shuffle 2 : ");
         SO.println(masterList1);


        // STAGE 11
        // Does Clear Work?
         SO.println();SO.println("Stage 11");SO.println();
         masterList1.clear();
         SO.print("After Clear    : ");
         SO.println(masterList1);


        // STAGE 12
        // Create a large list
        // And check that sort works.
         SO.println();SO.println("Stage 12");SO.println();
         for (int i=0; i <50; i++) {
            masterList1.add(new Card());
         }
         for (int i=0; i <5; i++) {
            masterList1.add(new PremiumCard());
         }

         SO.print("Before Sorted  : ");
         SO.println(masterList1);
         masterList1.sort();
         SO.print("Success Sorted : ");
         SO.println(masterList1);


        // STAGE 13
        // Check Mystery Method
         SO.println();SO.println("Stage 13");SO.println();

         SO.print("Before Mystery  : ");
         SO.println(masterList1);
         masterList1.reverse();
         SO.print("After Mystery : ");
         SO.println(masterList1);


        // STAGE 14
        // Can we create a second list
        // and make a copy of all NON premium cards
         SO.println();SO.println("Stage 14");SO.println();
         CardList masterList2 = new CardArrayList(1);

         for (int j = 0; j <masterList1.size(); j++) {
            if (!(masterList1.get(j) instanceof PremiumCard)) {
                masterList2.add(masterList1.get(j) );
             }
         }

         SO.print("Success Removed: ");
         SO.println(masterList2);


    }*/
}
