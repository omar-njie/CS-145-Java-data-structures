package com.omar.data_structures.assignments.assignment_3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Omar
 * @version 10/11/22
 */
public class LevenshteinFinder {

    private String from;
    private String to;
    private Map<String, Set<String>> words_list;
    private int distance = -1;
    private List<String> path;


    public LevenshteinFinder(String from, String to, Set<String> words_list) {
        this.from = from;
        this.to = to;

        if (from.length() != to.length()) {
            throw new IllegalArgumentException(
                    "The two words must be the same length"
            );
        }

        this.words_list = new TreeMap<>();
        for (String word : words_list) {
            if (word.length() == from.length()) {
                this.words_list.put(word, new TreeSet<>());
            }
        }
        for (String word : this.words_list.keySet()) {
            for (String word_2 : this.words_list.keySet()) {
                if (isNeighbor(word, word_2)) {
                    this.words_list.get(word).add(word_2);
                    this.words_list.get(word_2).add(word);
                }
            }
        }

        findDistance(from, to);
        findPath(from, to);

    }

    private boolean isNeighbor(String word, String word_2) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word_2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public int getDistance() {
        return distance;
    }

    public String getPath() {
        if (distance == -1) {
            return "There is no path";
        }
        return String.join("->", path);
    }


    private int findDistance(String from, String to) {
        Set<String> set_1 = new TreeSet<>(Set.of());
        Set<String> set_2 = new TreeSet<>(Set.of(from));
        int counter = 0;

        while (set_1.size() != set_2.size()
                && !set_2.contains(to)) {
            set_1.addAll(set_2);
            set_2.clear();
            for (String word : set_1) {
                set_2.addAll(words_list.get(word));
            }
            counter++;
        }

        if (set_2.contains(to)) {
            distance = counter;
            return counter;
        }
        return -1;
    }

    private void findPath(String from, String to) {
        /*
            This method will find the path between two words.
            Initialize the class path List to a new empty List.

            Check the distance, if it is negative, store an error message in the path List and then exit the method.

            If the distance is zero or positive add the first element to the list.

            Now in a loop that starts at the distance minus 1, and goes down until 1, look at the set of neighbors of the
            word in the last box of the list.  Find one that has a distance to the ending word that matches the current
            loop counter.   There may be multiples, but there has to be at least one.   Find this word and add it to the
            list.

            Now repeat the loop until the for loop quits.  Then add the ending word to the list.

            You are done.

            Here is an example for the path from love -> hate.

            The distance from love to hate is 3, so that is bigger than -1.   So, add love to the list.  The list
            is now size one.   Now start your loop from distance  -1 (2) to 1.   So, i is currently 2.   Find
            any  word  in  the  neighbor  of  love,  that  has  a  distance  to  hate  of  size  2.     Use  your
            findDistance method here!.  One of those words is "lave".   So add that to the array.

            Next  round,  i  is  one.      The  list  is  now  [love,  lave].    So,  find  a  neighbor  of  "lave"  that  has a
            distance to "hate" of one.   One possible word is "late".  So, add "late" to the list which now
            looks like [love, lave, late]

            That  should  finish  the  loop,  add  "hate"  to  the  list.    The  final  list  looks  like  [love,  lave,  late,
            hate].   Store that list in the class field.   And you are done.
        */
        path = new ArrayList<>();
        if (distance == -1) {
            path.add("There is no path");
            return;
        }
        path.add(from);
        if (distance == 0) {
            return;
        }
        for (int i = distance - 1; i > 0; i--) {
            String last = path.get(path.size() - 1);
            for (String word : words_list.get(last)) {
                if (findDistance(word, to) == i) {
                    path.add(word);
                    break;
                }
            }
        }
        path.add(to);
    }

    private int differentLetters(String from, String to) {
        int count = 0;
        int i = 0;
        while (i < from.length()) {
            if (from.charAt(i) != to.charAt(i)) {
                count++;
            }
            i++;
        }
        return count;
    }
}
