package com.omar.learn.implement_collections.linked_lists;

/**
 * @author Omar
 * @version 11/15/22
 */
public class RectangleLL<E extends Comparable<E>> {

    private RectNode<E> head;
    private int size;

    public RectangleLL() {
        head = null;
        size = 0;
    }

    public void add(E x) {
        if (head == null) {
            head = new RectNode<E>(x);
        } else { // walk to the end
            RectNode<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new RectNode<E>(x);
        }
        size++;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (head == null) return "[]";

        RectNode<E> current = head;
        while (current != null) {
            result.append(",").append(current.data.toString());
            current = current.next;
        }
        return "[" + result.substring(1) + "]";

    }

    public void remove(E x) {
        if (head == null)
            return;
        if (head.data.equals(x)) {
            head = head.next;
            size--;
            return;
        }
        RectNode<E> current = head;
        RectNode<E> behind = head;

        while (current != null && !current.data.equals(x)) {
            behind = current;          // move behind up
            current = current.next;    // move front ahead.
        }
        if (current == null)
            return;
        else {
            behind.next = current.next;
            size--;
        }

    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(E find) {
        RectNode<E> current = head;
        while (current != null) {
            if (current.data.equals(find))
                return true;
            current = current.next;
        }
        return false;
    }

    public void add(int loc, E x) {
        if (loc < 0)
            throw new IllegalArgumentException("Negative Index");
        else if (loc > size)
            throw new IllegalArgumentException("Index to large");
        else if (loc == size)
            add(x);
        else if (loc == 0) {
            RectNode<E> temp = new RectNode<E>(x);
            temp.next = head;
            head = temp;
            size++;
        } else { // Anywhere else in the list
            RectNode<E> current = head;
            for (int i = 1; i < loc; i++)
                current = current.next;
            RectNode<E> temp = new RectNode<E>(x);
            temp.next = current.next;
            current.next = temp;
            size++;
        }

    }

    public void sort() {
        if (head == null)
            return;
        RectNode<E> current = head;
        while (current != null) {
            RectNode<E> min = current;
            RectNode<E> minBehind = current;
            RectNode<E> behind = current;
            RectNode<E> front = current.next;
            while (front != null) {
                if (front.data.compareTo(min.data) < 0) {
                    min = front;
                    minBehind = behind;
                }
                behind = front;
                front = front.next;
            }
            E temp = current.data;
            current.data = min.data;
            min.data = temp;
            current = current.next;
        }

    }


    private static class RectNode<E> {
        public E data;
        public RectNode<E> next;

        public RectNode(E x) {
            data = x;
            next = null;
        }
    }
}
