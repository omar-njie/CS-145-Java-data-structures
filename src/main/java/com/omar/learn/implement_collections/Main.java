package com.omar.learn.implement_collections;

/**
 * @author Omar
 * @version 11/4/22
 */
public class Main {

    public static void main(String[] args) {
        ArrayIntList list1 = new ArrayIntList(100);
        ArrayIntList list2 = new ArrayIntList(100);
        ArrayIntList list3 = new ArrayIntList();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(4);
        list2.add(-5);
        list2.add(-6);

        // report results
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("size of list1: " + list1.getSize());
        System.out.println("size of list2: " + list2.getSize());
        System.out.println("element 0 of list1: " + list1.get(0));
        System.out.println("element 1 of list2: " + list2.get(1));
        System.out.println("index of 3 in list1: " + list1.indexOf(3));
        System.out.println("index of -5 in list2: " + list2.indexOf(-5));
        list1.remove(1);
        System.out.println("list1 after removing element 1: " + list1);
    }

}
