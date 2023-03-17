package com.omar.learn.implement_collections.linked_lists;

/**
 * @author Omar
 * @version 11/16/22
 */
public class LinkedIntList {

    private ListNodeEx front;

    public LinkedIntList() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNodeEx current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: returns the postion of the first occurrence of the
    //       given value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNodeEx current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null)
            front = new ListNodeEx(value);
        else {
            ListNodeEx current = front;
            while (current.next != null)
                current = current.next;
            current.next = new ListNodeEx(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0)
            front = new ListNodeEx(value, front);
        else {
            ListNodeEx current = nodeAt(index - 1);
            current.next = new ListNodeEx(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0)
            front = front.next;
        else {
            ListNodeEx current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre: 0 <= index < size()
    // post: returns a reference to the node at the given index
    private ListNodeEx nodeAt(int index) {
        ListNodeEx current = front;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    // post: creates a comma-separated, bracketed version of the list
    @Override
    public String toString() {
        if (front == null)
            return "[]";
        else {
            StringBuilder result = new StringBuilder("[" + front.data);
            ListNodeEx current = front.next;
            while (current != null) {
                result.append(", ").append(current.data);
                current = current.next;
            }
            result.append("]");
            return result.toString();
        }
    }

    public void addSorted(int value) {
        ListNodeEx prev = null;
        ListNodeEx current = front;
        while (current != null && current.data < value) {
            prev = current;
            current = current.next;
        }
        if (prev == null)
            front = new ListNodeEx(value, front);
        else
            prev.next = new ListNodeEx(value, current);
    }

    public String getSize() {
        return "Size: " + size();
    }

    public boolean hasOddEven() {
        ListNodeEx current = front;
        while (current != null) {
            if (current.data % 2 == 0)
                return true;
            current = current.next;
        }
        return false;
    }

    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
