package com.omar.data_structures.assignments.assignment_3;

import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * This is the driver class for the Find Levenshtein Distance program.
 * This program will load the dictionary file, find the two target words
 * that the program is working to find a path from,
 * and the give those to the solver class that the students will need to
 * write.
 *
 * @author Michael W. Wood
 * @version 2.2  - September 2022
 */
public class LevenDistanceFinderMain {
    private Set<String> masterDictionary;

    public static void main(String[] args) {
        LevenDistanceFinderMain program = new LevenDistanceFinderMain();
        program.run();
    }

    /**
     * This method runs the main program instance, and kicks off the user
     * input and data file collection routines.
     */
    public void run() {
        masterDictionary = createSet();

        WordPair path;
        path = getStartingWords();

        // This is the line that creates the student
        // Generated code and gives it the necessary methods
        final long startTime = System.currentTimeMillis();
        LevenshteinFinder myMain = new LevenshteinFinder(path.from, path.to, masterDictionary);
        final long endTime = System.currentTimeMillis();

        // From the student class, we ask the class for the
        // distance that it found, and the path that goes with it.
        int dist = myMain.getDistance();
        String thePath = myMain.getPath();

        System.out.println("The distance between your words is " + dist);
        System.out.println("The path between your words is : " + thePath);
        System.out.println("******************************************************************");
        System.out.println("Total execution time: " + (endTime - startTime) + "ms.");
        System.out.println("\t\t\t\t\t\s\s" + (endTime - startTime) / 1000.0 + "s.");
    }


    // This method is a replacement for Scanner.next() that has a side
    // benefit of checking that the word is in the delivered dictionary.
    // Note it also forces a lowercase onto the word
    private String getWordInDictionary(Scanner x) {
        System.out.print("---> ");
        String word = x.next().trim().toLowerCase();
        while (!masterDictionary.contains(word)) {
            System.out.println("Please type in a word in the dictionary");
            System.out.print("---> ");
            word = x.next().toLowerCase();
        }
        return word.toLowerCase();
    }


    // Returns a small data structure that contains the two words
    // that are of interest. The word to start from, and the word
    // to end with.
    private WordPair getStartingWords() {
        Scanner keyboard = new Scanner(System.in);
        WordPair x = new WordPair();
        System.out.println("* Welcome to the Levenshtein Edit distance solver               *");
        System.out.println("* Please type in two words of the same size that will be used   *");
        System.out.println("* To find a path between them.                                  *");
        System.out.println("*****************************************************************");
        System.out.println();
        System.out.println("What word would you like to start with?");
        x.from = getWordInDictionary(keyboard);
        System.out.println("What word would you like to end with?");
        x.to = getWordInDictionary(keyboard);

        while (x.from.length() != x.to.length()) {
            System.out.println("******");
            System.out.println("Please make sure the two words are the same size!");
            System.out.println("What word would you like to start with?");
            x.from = getWordInDictionary(keyboard);
            System.out.println("What word would you like to end with?");
            x.to = getWordInDictionary(keyboard);
        }
        return x;
    }


    // This method opens up the data file, and reads all the words from
    // the dictionary file and sorts them into sets of the correct size.
    // From this dictionary the final group of dictionary words is found.
    private Set<String> createSet() {
        File mainDictionary = new File("dictionary.txt");
        Scanner fileRead = null;
        try {
            fileRead = new Scanner(mainDictionary);
        } catch (Exception e) {
            System.out.println("Dictionary File not found.  Please locate file");
            System.out.println("    Error -- " + e);
            System.exit(-1);
        }

        Set<String> wordGroups = new TreeSet<>();
        while (fileRead.hasNext()) {
            String w = fileRead.next();
            wordGroups.add(w);
        }
        return wordGroups;
    }

    // This is a private class that is acting like a struct from c++
    // used to hold a pair of words.
    private static class WordPair {
        public String from;
        public String to;
    }
}