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
        size = 0;
    }

    private CardNode<Card> nodeAt(int index) {
        CardNode<Card> current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
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
        size++;
    }

    public void add(int l, Card c) {
        check_index(l);
        if (l == 0) {
            front = new CardNode<Card>(c, front);
        } else {
            CardNode<Card> current = nodeAt(l - 1);
            current.next = new CardNode<Card>(c, current.next);
        }
        size++;
    }


   public Card remove() {
        if (front == null)
            return null;
        CardNode<Card> current = front;
        front = front.next;
        size--;
        return current.item;
   }

    public Card remove(int j) {
        check_index(j);
        if (j == 0) {
            CardNode<Card> current = front;
            front = front.next;
            size--;
            return current.item;
        } else {
            CardNode<Card> current = nodeAt(j - 1);
            CardNode<Card> temp = current.next;
            current.next = current.next.next;
            size--;
            return temp.item;
        }
    }

    public Card get(int x) {
        check_index(x);
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
        if (size <= 1)
            return;
        CardLinkedList left = new CardLinkedList();
        CardLinkedList right = new CardLinkedList();
        int half = size / 2;
        for (int i = 0; i < half; i++)
            left.add(this.remove());
        while (size > 0)
            right.add(this.remove());
        left.sort();
        right.sort();
        merge(left, right);

    }

    private void sort(CardLinkedList x) {
        if (x.size <= 1)
            return;
        CardLinkedList left = new CardLinkedList();
        CardLinkedList right = new CardLinkedList();
        int half = x.size / 2;
        for (int i = 0; i < half; i++)
            left.add(x.remove());
        while (x.size > 0)
            right.add(x.remove());
        sort(left);
        sort(right);
        merge(left, right);
    }

    private void merge(CardLinkedList left, CardLinkedList right) {
        while (left.size() + right.size() > 0) {
            if (left.size() == 0)
                this.add(right.remove());
            else if (right.size() == 0)
                this.add(left.remove());
            else if (left.front.item.compareTo(right.front.item) < 0)
                this.add(left.remove());
            else
                this.add(right.remove());
        }
    }


    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < size * 5; i++) {
            int a = rand.nextInt(size);
            int b = rand.nextInt(size);
            swap(a, b);
        }
    }

    public void clear() {
        front = null;
        size = 0;
    }

    private void swap(int a, int b) {
        CardNode<Card> current = front;
        CardNode<Card> current2 = front;
        for (int i = 0; i < a; i++)
            current = current.next;
        for (int i = 0; i < b; i++)
            current2 = current2.next;
        Card temp = current.item;
        current.item = current2.item;
        current2.item = temp;
    }


    public void reverse() {
        Stack<Card> stack = new Stack<Card>();
        while (this.size > 0)
            stack.push(this.remove());
        while (!(stack.isEmpty()))
            this.add(stack.pop());
    }

    private void check_index(int index) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException("Index " + index);
    }

    private static class CardNode<E> {
        E item;
        CardNode<E> next;

        CardNode(E item) {
            this.item = item;
            this.next = null;
        }

        CardNode(E item, CardNode<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
