package com.omar.learn.learn_collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Omar
 * @version 10/10/22
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("two");
        list.add("ze");
        list.add("40");
        list.add("5");
        list.add("6");

        //removeEvenLength(list);
        System.out.println(removeEvenLength(list));

        /*
        * Set: Interface
        * HashSet: Implementation
        * TreeSet: Implementation
        *
        * Properties:
        * 1. Unordered collection
        * 2. Cannot store duplicate elements
        * 3. It has a constant time complexity for the basic operations (add, remove, contains)
        * 4. It has more implementation such as HashSet, TreeSet, TreeHashSet, LinkedHashSet
        *
        */
        /*Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("two");
        set.add("2");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println();
        Set<Integer> t = new TreeSet<>();
        t.add(1);
        t.add(2);
        t.add(4);
        t.add(3);
        t.add(0);
        t.forEach(System.out::println);*/

        /*
        * Map: Interface
        * HashMap: Implementation
        * TreeMap: Implementation
        *   Map Properties:
        *       1. They contain values based on the key
        *       2. They cannot contain duplicate keys
        *       3. They are not ordered
        *       4. "Key" is unique, "Value" can be duplicated
        *       5. It has more implementation such as HashMap, TreeMap, LinkedHashMap
        */

        Map<String, String> fruits = new HashMap<>();
        fruits.put("Apple", "Red");
        fruits.put("Banana", "Yellow");
        fruits.put("Orange", "Orange");
        fruits.put("Grape", "Purple");

        fruits.forEach((k, v) -> System.out.println(k + " is " + v));
        for (Map.Entry<String, String> entry : fruits.entrySet()) {
            System.out.println(entry.getKey() + " is " + entry.getValue());
        }
        Map<String, Set<String>> dictionary = new HashMap<>();
        dictionary.put("hello", Set.of("hi", "hey", "howdy"));
        dictionary.put("goodbye", Set.of("bye", "see ya", "later"));
        System.out.println();
        dictionary.forEach((k, v) -> System.out.println(k + " is " + v));
        System.out.println(dictionary.containsValue(Set.of("hi", "hey", "howdy")));


             /*  this.words_list = words_list.stream()
                .filter(word -> word.length() == from.length())
                .collect(Collectors.toMap(word -> word, word -> Set.of()));
        for (String word : this.words_list.keySet()) {
            for (String word2 : this.words_list.keySet()) {
                if (isNeighbor(word, word2)) {
                    this.words_list.get(word).add(word2);
                    this.words_list.get(word2).add(word);
                }
            }
        }
        findDistance(from, to);
        findPath(from, to);*/
    }

    // removes all strings of even length from the given list
    public static List<String> removeEvenLength(List<String> list) {
        return list.stream()
                .filter(s -> s.length() % 2 != 0)
                .collect(Collectors.toList());
    }

}
