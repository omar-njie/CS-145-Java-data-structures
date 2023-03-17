package com.omar.data_structures.assignments.assignment_5;

import java.util.Random;
import java.util.Stack;

/**
 * The CardLinkedList class the {@link CardList} interface.
 * It implements this following methods:
 * <ul>
 *     <li>{@link CardList#toString()}</li>
 *     <li>{@link CardList#size()}</li>
 *     <li>{@link CardList#add(Card)}</li>
 *     <li>{@link CardList#add(int, Card)}</
 *     <li>{@link CardList#remove()}</li>
 *     <li>{@link CardList#remove(int)}</li>
 *     <li>{@link CardList#get(int)}</li>
 *     <li>{@link CardList#indexOf(Card)}</l
 *     <li>{@link CardList#sort()}</li>
 *     <li>{@link CardList#shuffle()}</li>
 *     <li>{@link CardList#clear()}</li>
 *     <li>{@link CardList#reverse()}</li>
 * </ul>
 * The class has some additional helper methods such as {@link CardLinkedList#nodeAt(int)},
 * {@link CardLinkedList#swap(int, int)}, {@link CardLinkedList#check_index_pos(int)} and
 * {@link CardLinkedList#check_element_index(int)}.
 * It also implements the merge sort algorithm; {@link CardLinkedList#sort()}, with
 * this helper methods: {@link CardLinkedList#merge(CardLinkedList, CardLinkedList)} and
 * {@link CardLinkedList#sort(CardLinkedList)} to sort the list from least to greatest.
 *
 * @author Omar
 * @version 11.17.22
 * @see StringBuilder
 */
public class CardLinkedList implements CardList {

    private CardNode<Card> front;
    private int size;


    /**
     * Creates a CardLinkedList object and sets the front to null and the size to 0.
     */
    public CardLinkedList() {
        front = null;
        this.size = 0;
    }


    /**
     * Returns the current number of elements in the list.
     *
     * @return the {@code size} of the list
     */
    public int size() {
        return this.size;
    }


    /**
     * This method should add a card to the end of the list in the first available spot.
     *
     * @param x the Card object to be added.
     */
    public void add(Card x) {
        if (front == null) {
            front = new CardNode<>(x);
        } else {
            CardNode<Card> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new CardNode<>(x);
        }
        size += 1;
    }


    /**
     * Add a card to the indicated location
     * sliding all other elements over one.
     *
     * @param l the desired index of the card to be added.
     * @param x the Card object to be added.
     * @throws IndexOutOfBoundsException {@code if (l >= 0 && l <= this.size) {}} is outside the current list.
     */
    public void add(int l, Card x) {
        check_index_pos(l);
        if (l == 0) {
            front = new CardNode<>(x, front);
        } else {
            CardNode<Card> current = nodeAt(l - 1);
            current.next = new CardNode<>(x, current.next);
        }
        size += 1;
    }


    /**
     * Remove the last element from the list.
     *
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
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


    /**
     * Remove the identified card from the list and return it.
     *
     * @param j the index of the card to be removed.
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException {@code if (j >= 0 && j < this.size) {}}
     *                                   is outside the current list.
     */
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


    /**
     * Return the i'th last element from the list.
     *
     * @param x The index of the desired card.
     * @return The card object located in index x from the list.
     * @throws IndexOutOfBoundsException {@code if (x >= 0 && x < this.size) {}}
     *                                   is outside the current list.
     * @see CardLinkedList#nodeAt(int)
     */
    public Card get(int x) {
        check_element_index(x);
        return nodeAt(x).item;
    }


    /**
     * Returns the index of specified Card object
     *
     * @param x Card object
     * @return {@code index} of Card otherwise -1 if not found
     */
    public int indexOf(Card x) {
        CardNode<Card> current = front;
        for (int i = 0; i < this.size; i++) {
            if (current.item.equals(x)) return i;
            current = current.next;
        }
        return -1;
    }


    /**
     * Sort the items in the list from smallest to largest
     */
    public void sort() {
        this.sort(this);
    }


    /**
     * Shuffle the items in the list.
     *
     * @see CardLinkedList#swap(int, int)
     */
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < size * 5; i++) {
            int a = rand.nextInt(size);
            int b = rand.nextInt(size);
            swap(a, b);
        }
    }

    /**
     * Empty the list of all items.
     */
    public void clear() {
        front = null;
        this.size = 0;
    }

    /**
     * Reverse the sorted list from largest to smallest.
     */
    public void reverse() {
        Stack<Card> stack = new Stack<>();
        while (this.size > 0) stack.push(this.remove(0));
        while (!(stack.isEmpty())) this.add(stack.pop());
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
            if (current.next != null) sb.append(",");
            current = current.next;
        }
        sb.append(" | ").append(this.size()).append("]");
        return sb.toString();
    }


    // -----------------------# Helper Methods #-----------------------//

    private void sort(CardLinkedList x) {
        if (x.size <= 1) return;
        CardLinkedList left = new CardLinkedList();
        CardLinkedList right = new CardLinkedList();
        int half = x.size / 2;
        for (int i = 0; i < half; i++)
            left.add(x.remove(0));
        while (x.size > 0) right.add(x.remove(0));
        left.sort();
        right.sort();
        merge(left, right);
    }


    private void merge(CardLinkedList start, CardLinkedList end) {
        while (start.size() + end.size() > 0) {
            if (start.size() == 0) this.add(end.remove(0));
            else if (end.size() == 0) this.add(start.remove(0));
            else if (start.front.item.compareTo(end.front.item) < 0)
                this.add(start.remove(0));
            else this.add(end.remove(0));
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

    // -----------------------# End Of Helper Methods # -----------------------//

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
