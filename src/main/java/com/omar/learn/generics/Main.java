package com.omar.learn.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Omar
 * @version 11/16/22
 */
public class Main {

    public static void main(String[] args) {

        Printer<Car> int_printer = new Printer<>(new Car("Toyota", "Camry", 2015, 4));
        int_printer.print();

        Printer<Bus> string_printer = new Printer<>(new Bus("Toyota", "Camry", 2015, 4));
        string_printer.print();

        printArray(new Integer[]{1, 2, 3, 4, 5}, new String[]{"a", "b", "c", "d", "e"});
        shout("hello", "world");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        printList(list);
    }


    private static <T, V> void printArray(T[] array, V[] index) {
        for (T element : array) {
            System.out.print(element + " ");
        }

        for (V element : index) {
            System.out.print(element + " ");
        }

    }


    private static <T, V> T shout(T thingToShout, V otherThing) {
        System.out.println(thingToShout + " " + otherThing);
        return thingToShout;
    }


    private static void printList(List<?> myList) {
        System.out.println(myList);
    }
}
