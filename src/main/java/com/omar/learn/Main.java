package com.omar.learn;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {


    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        list.add(1, "2twos");
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.get(2));
        for (String s : list) {
            System.out.println(s);
        }
        int sum = 0;
        for (String s : list) {
            sum += s.length();
        }
        System.out.println("Total of lengths = " + sum);
        list.set(0, "new1");
        System.out.println(list);
        list.clear();
        System.out.println(list);


    }



}


