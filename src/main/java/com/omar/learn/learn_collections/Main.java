package com.omar.learn.learn_collections;

import java.util.ArrayList;
import java.util.List;
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

    }

    // removes all strings of even length from the given list
    public static List<String> removeEvenLength(List<String> list) {
        return list.stream()
                .filter(s -> s.length() % 2 != 0)
                .collect(Collectors.toList());
    }

}
