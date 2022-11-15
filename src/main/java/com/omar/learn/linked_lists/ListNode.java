package com.omar.learn.linked_lists;


/**
 * @author Omar
 * @version 11/15/22
 */
public class ListNode {

    // usual approach for defining a node, no encapsulation
    public int data;
    public ListNode next;

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.data = 1;
        list.next = new ListNode();
        list.next.data = 2;
        list.next.next = new ListNode();
        list.next.next.data = 3;
        list.next.next.next = null;
        System.out.println(list.data + " " + list.next.data + " " + list.next.next.data);


        Rectangle a = new Rectangle();
        Rectangle b = new Rectangle(3);
        Rectangle c = new Rectangle(3,7);

        RectangleLL<Rectangle> myList = new RectangleLL<>();
        System.out.println(myList.size());
        for(int i = 0; i < 20; i++)
            myList.add(new Rectangle(i));

        myList.add(12,a);
        System.out.println(myList);
    }

}
