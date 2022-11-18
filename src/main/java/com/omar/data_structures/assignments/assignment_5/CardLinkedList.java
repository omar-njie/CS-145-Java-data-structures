package com.omar.data_structures.assignments.assignment_5;

import java.util.Random;
import java.util.Stack;

/**
 * @author Omar
 * @version 11/11/22
 */
public class CardLinkedList implements CardList {

    private CardNode<Card> front;
    private int size;


    public CardLinkedList() {
        front = null;
        this.size = 0;
    }




    public int size() {
        return this.size;
    }

    public void add(Card c) {
        if (front == null) {
            front = new CardNode<Card>(c);
        } else {
            CardNode<Card> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new CardNode<Card>(c);
        }
        size += 1;
    }

    public void add(int l, Card c) {
        check_index_pos(l);
        if (l == 0) {
            front = new CardNode<Card>(c, front);
        } else {
            CardNode<Card> current = nodeAt(l - 1);
            current.next = new CardNode<Card>(c, current.next);
        }
        size += 1;
    }


   public Card remove() {
       if (front == null)
           throw new IndexOutOfBoundsException("The list is empty");
       CardNode<Card> current = front;
       CardNode<Card> behind = front;
       while (current.next != null) {
           behind = current;
           current = current.next;
       }
       Card c = current.item;
       behind.next = null;
       size -= 1;
       return c;

   }


    public Card remove(int j) {
        check_element_index(j);
        if (j == 0) {
            CardNode<Card> current = front;
            front = front.next;
            size -= 1;
            return current.item;
        }
        CardNode<Card> current = nodeAt(j - 1);
        CardNode<Card> temp = current.next;
        current.next = current.next.next;
        size -= 1;
        return temp.item;
    }

    public Card get(int x) {
        check_element_index(x);
        return nodeAt(x).item;
    }

    public int indexOf(Card x) {
        CardNode<Card> current = front;
        for (int i = 0; i < this.size; i++) {
            if (current.item.equals(x))
                return i;
            current = current.next;
        }
        return -1;
    }

    public void sort() {
        this.sort(this);
    }

    public void clear() {
        front = null;
        this.size = 0;
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < size * 5; i++) {
            int a = rand.nextInt(size);
            int b = rand.nextInt(size);
            swap(a, b);
        }
    }


    public void reverse() {
        Stack<Card> stack = new Stack<Card>();
        while (this.size > 0)
            stack.push(this.remove(0));
        while (!(stack.isEmpty()))
            this.add(stack.pop());
    }


    @Override
    public String toString() {
        if (front == null)
            return "[0 | " + this.size() + "]";
        StringBuilder sb = new StringBuilder();
        sb.append("[0 | ");
        CardNode<Card> current = front;
        while (current != null) {
            sb.append(current.item.toString());
            if (current.next != null)
                sb.append(",");
            current = current.next;
        }
        sb.append(" | ").append(this.size()).append("]");
        return sb.toString();
    }

    private void sort(CardLinkedList x) {
        if (x.size <= 1)
            return;
        CardLinkedList left = new CardLinkedList();
        CardLinkedList right = new CardLinkedList();
        int half = x.size / 2;
        for (int i = 0; i < half; i++)
            left.add(x.remove(0));
        while (x.size > 0)
            right.add(x.remove(0));
        left.sort();
        right.sort();
        merge(left, right);
    }

    private void merge(CardLinkedList start, CardLinkedList end) {
        while (start.size() + end.size() > 0) {
            if (start.size() == 0)
                this.add(end.remove(0));
            else if (end.size() == 0)
                this.add(start.remove(0));
            else if (start.front.item.compareTo(
                    end.front.item) < 0)
                this.add(start.remove(0));
            else
                this.add(end.remove(0));
        }
    }

    private void swap(int a, int b) {
        CardNode<Card> current = front;
        CardNode<Card> current_2 = front;
        for (int i = 0; i < a; i++)
            current = current.next;
        for (int i = 0; i < b; i++)
            current_2 = current_2.next;
        Card temp = current.item;
        current.item = current_2.item;
        current_2.item = temp;
    }


    /**
     * @param index the index of the element to return
     * @return the {@code current} element at the given index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private CardNode<Card> nodeAt(int index) {
        check_index_pos(index);
        CardNode<Card> current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private String bound_message(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }

    // pos = position
    private void check_index_pos(int index) {
        if (!(is_position(index)))
            throw new IndexOutOfBoundsException(bound_message(index));
    }

    private boolean is_position(int index) {
        return index >= 0 && index <= this.size;
    }

    private boolean is_element_index(int index) {
        return index >= 0 && index < this.size;
    }

    private void check_element_index(int index) {
        if (!(is_element_index(index)))
            throw new IndexOutOfBoundsException(bound_message(index));
    }


    private static class CardNode<E> {
       E item;
       CardNode<E> next;

        CardNode(E item) {
            this.item = item;
            next = null;
        }

        CardNode(E item, CardNode<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
