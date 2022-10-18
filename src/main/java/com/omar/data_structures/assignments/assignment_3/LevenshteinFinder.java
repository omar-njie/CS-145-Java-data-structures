package com.omar.data_structures.assignments.assignment_3;

import java.util.*;

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
