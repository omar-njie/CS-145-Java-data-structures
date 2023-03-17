package com.omar.data_structures.assignments.assignment_3;

import java.util.*;

/**
 * The Levenshtein Finder class is responsible for finding the distance and the path
 * between two words.
 *
 * @author Omar
 * @version 10.20.22
 */
public class LevenshteinFinder {

    private final Map<String, Set<String>> words_list;
    private final int distance;
    private List<String> path;

    /**
     * Create a new Levenshtein Finder that takes a <u><i>word</i></u> to from a <u><i>word</i></u>
     * it searches through a set of words to find a path that lead to the <u><i>to word</i></u>.
     *
     * @param from       the starting word
     * @param to         the goal word
     * @param words_list the words from the dictionary
     * @throws IllegalArgumentException if the two entered words from the use aren't the same length.
     */
    public LevenshteinFinder(String from, String to, Set<String> words_list) {
        if (from.length() != to.length())
            throw new IllegalArgumentException(
                    "The two words must be the same length");

        this.path = new ArrayList<>();
        this.words_list = new TreeMap<>();
        for (String word : words_list) {
            if (word.length() == from.length()) {
                this.words_list.put(word, new TreeSet<>());
            }
        }

        for (String word : this.words_list.keySet()) {
            for (String word_2 : this.words_list.keySet()) {
                int is_neighbor = differentLetters(word, word_2);
                if (is_neighbor == 1) {
                    this.words_list.get(word).add(word_2);
                    this.words_list.get(word_2).add(word);
                }
            }
        }

        this.distance = findDistance(from, to);
        findPath(from, to);
    }


    /**
     * @return distance between the two words
     */
    public int getDistance() {
        return this.distance;
    }


    /**
     * @return No path if the distance is -1, & the delimiter "->" + path
     * NOTE: the first word before the delimiter was entered by the user.
     * @see String#join(CharSequence, Iterable)
     */
    public String getPath() {
        if (this.distance == -1)
            return "There is no path";
        return String.join("->", this.path); // join two strings with the delimiter "->"
    }


    private int findDistance(String from, String to) {
        Set<String> set_1 = new TreeSet<>();
        Set<String> set_2 = new TreeSet<>();
        set_2.add(from);

        int counter = 0;
        while (set_1.size() != set_2.size() && !set_2.contains(to)) {
            set_1.addAll(set_2);
            set_2.clear();
            for (String word : set_1) {
                set_2.addAll(this.words_list.get(word)); // get all the words from set 1
                set_2.add(word); // and add them to set 2.
            }
            counter++;
        }

        // if the set_2 contains the "to word" return counter else return -1
        return set_2.contains(to) ? counter : -1;
    }

    private void findPath(String from, String to) {
        this.path = new ArrayList<>();

        if (this.distance == -1) {
            this.path.add("There is no path");
            return;
        }
        this.path.add(from);

        if (this.distance == 0)
            return;

        for (int k = distance - 1; k > 0; k--) {
            String last = this.path.get(path.size() - 1);
            for (String word : this.words_list.get(last)) {
                if (findDistance(word, to) == k) {
                    this.path.add(word);
                    break;
                }
            }
        }
        this.path.add(to);
    }

    private int differentLetters(String from, String to) {
        int count = 0;
        int i = 0;
        while (i < from.length()) {
            if (from.charAt(i) != to.charAt(i))
                count++;
            i++;
        }
        return count;
    }
}
