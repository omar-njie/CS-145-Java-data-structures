package com.omar.learn.implement_collections.linked_lists;


import com.omar.data_structures.assignments.assignment_5.Card;

/**
 * @author Omar
 * @version 11/15/22
 */
public class ListNodeEx {

    // usual approach for defining a node, no encapsulation
    public int data;
    public ListNodeEx next;

    // post: constructs a node with data 0 and null link
    public ListNodeEx() {
        this(0, null);
    }

    // post: constructs a node with given data and null link
    public ListNodeEx(int data) {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListNodeEx(int data, ListNodeEx next) {
        this.data = data;
        this.next = next;
    }

    public static void main(String[] args) {
        ListNodeEx list = new ListNodeEx(3,
                new ListNodeEx(4, new ListNodeEx(5)));
        System.out.println(list.data + " " + list.next.data + " " + list.next.next.data);



        Rectangle a = new Rectangle();
        Rectangle b = new Rectangle(3);
        Rectangle c = new Rectangle(3,7);

        RectangleLL<Rectangle> myList = new RectangleLL<>();
        System.out.println(myList.size());
        for(int i = 0; i < 20; i++)
            myList.add(new Rectangle(i));
        RectangleLL<Card> cardList = new RectangleLL<>();

        myList.add(12,a);
        System.out.println(myList);
    }

}
