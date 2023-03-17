package com.omar.learn.implement_collections.linked_lists;

import java.util.LinkedList;

/**
 * @author Omar
 * @version 11/14/22
 */
public class LinkedListsEx {

    public static void main(String[] args) {

        // --------------------------------------------------------------------
        // LinkedList = stores index in 2 parts (data + address of next node)
        //              Nodes are in non-consecutive memory locations
        //              Elements are linked using pointers

        //                                  Singly Linked List
        //                                  ------------------
        //                   Node                Node                 Node
        //              [data | address] <-> [data | address] <-> [data | address]

        //                                  Doubly Linked List
        //                                  ------------------
        //                         Node                           Node                           Node
        //              [address | data | address] <-> [address | data | address] <-> [address | data | address]

        //              advantages:
        //              1. Dynamic Data Structure (allocates needed memory while running)
        //              2. Insertion and Deletion of Nodes is easy. 0(1)
        //              3. No/Low memory waste

        //              disadvantages:
        //              1. Greater memory usage (additional pointer)
        //              2. No random access of elements (no index [i])
        //              3. Accessing/searching elements is more time consuming. O(n)
        //

        //              uses?
        //              1. implement Stacks/Queues
        //              2. GPS navigation
        //              3. music playlist

        // --------------------------------------------------------------------

        LinkedList<String> list = new LinkedList<>();
        /*
        list.push("A");
        list.push("B");
        list.push("C");
        list.push("D");
        list.push("F");
        list.pop();
        */
        list.offer("A");
        list.offer("B");
        list.offer("C");
        list.offer("D");
        list.offer("F");
        //list.poll();

        list.add(4, "E");
        list.remove("E");
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        list.addFirst("0");
        list.addLast("G");

        System.out.println("List: " + list);
    }
}
