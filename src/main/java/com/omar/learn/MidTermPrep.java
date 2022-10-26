package com.omar.learn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Omar
 * @version 10/26/22
 */
public class MidTermPrep {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("four");
        list.add("score");
        list.add("and");
        list.add("seven");
        list.add("years");
        list.add("ago");
        removeShorterStrings(list);
        Set<String> s = new TreeSet<>();
        // "foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"
        s.add("foo");
        s.add("buzz");
        s.add("bar");
        s.add("fork");
        s.add("bort");
        s.add("spoon");
        s.add("!");
        s.add("dude");
        removeEvenLength(s);



    }

    void mystery(ArrayList<Integer> list) {
        list.add(30);
        list.add(20);
        list.add(10);
        list.add(60);
        list.add(50);
        list.add(40);
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) < list.get(i - 1)) {
                int element = list.get(i);
                list.remove(i);
                list.add(0, element);
            }
        }
        System.out.println(list);
    }


    public static void removeShorterStrings(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).length() < list.get(i + 1).length()) {
                list.remove(i);
                i--;
            } else if (list.get(i).length() > list.get(i + 1).length()) {
                list.remove(i + 1);
                i--;
            }
        }
        System.out.println(list);
    }



    public static void removeEvenLength(Set<String> set) {
        Set<String> temp = new TreeSet<String>();

        for (String x : set) {
            if (x.length() % 2 == 0) {
                temp.add(x);
            }
        }
        for (String x : temp) {
            set.remove(x);
        }
    }



}
