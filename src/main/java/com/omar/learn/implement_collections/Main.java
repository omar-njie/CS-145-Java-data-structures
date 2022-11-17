package com.omar.learn.implement_collections;

import com.omar.learn.implement_collections.array_list.ArrayIntList;
import com.omar.learn.implement_collections.linked_lists.LinkedIntList;

/**
 * @author Omar
 * @version 11/4/22
 */
public class Main {

    public static void main(String[] args) {
        ArrayIntList list1 = new ArrayIntList(100);
        ArrayIntList list2 = new ArrayIntList(100);

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
        System.out.println();

        LinkedIntList list3 = new LinkedIntList();
        LinkedIntList list4 = new LinkedIntList();

        list3.add(3);
        list3.add(4);
        list3.add(5);

        list4.add(-6);
        list4.add(7);
        list4.add(8);

        // report results
        System.out.println("list3: " + list3);
        System.out.println("list4: " + list4);
        System.out.println("size of list3: " + list3.getSize());
        System.out.println("size of list4: " + list4.getSize());
        System.out.println("element 0 of list3: " + list3.get(0));
        System.out.println("element 1 of list4: " + list4.get(1));
        System.out.println("index of 3 in list3: " + list3.indexOf(3));
        System.out.println("index of -9 in list4: " + list4.indexOf(-9));
        list3.remove(1);
        System.out.println("list3 after removing element 1: " + list3);
        list3.add(0, 10);
        System.out.println("list3 after adding 10 at index 0: " + list3);
    }
}
