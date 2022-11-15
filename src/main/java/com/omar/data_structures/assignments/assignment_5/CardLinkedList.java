package com.omar.data_structures.assignments.assignment_5;

import java.util.LinkedList;
/**
 * @author Omar
 * @version 11/11/22
 */
public class CardLinkedList implements CardList {

    /**
     * This method should return the current number of elements in the list.
     *
     * @return the size of the list as an integer
     */
    public int size() {
        return 0;
    }

    /**
     * This method should add a card to the end of the list in the first available spot.
     *
     * @param c the Card object to be added.
     */
    public void add(Card c) {

    }

    /**
     * This method should add a card to the indicated location
     * sliding all other elements over one.
     *
     * @param loc the desired index of the card to be added.
     * @param c   the Card object to be added.
     * @throws IndexOutOfBoundsException if the loc is outside the current list.
     */
    public void add(int loc, Card c) {

    }

    /**
     * This method should remove the last element from the list.
     *
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    public Card remove() {
        return null;
    }

    /**
     * This method should remove the identified card from the list and return it.
     *
     * @param loc the index of the card to be removed.
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException if the loc is outside the current array size.
     */
    public Card remove(int loc) {
        return null;
    }

    /**
     * This method should return the i'th last element from the list.
     *
     * @param i The index of the desired card.
     * @return The card object located in index x from the list.
     * @throws IndexOutOfBoundsException if the i value is outside the range of the list
     */
    public Card get(int i) {
        return null;
    }

    /**
     * Returns the index of specified Card object
     *
     * @param c Card object
     * @return index of Card otherwise -1 if not found
     */
    public int indexOf(Card c) {
        return 0;
    }

    /**
     * Sort the items in the list from smallest to largest
     */
    public void sort() {

    }

    /**
     * Apply a weak shuffle algorithm to rearrange the items in the list.
     */
    public void shuffle() {

    }

    /**
     * Empty the list of all items.
     */
    public void clear() {

    }

    /**
     * Reverse the list from the first to last element.
     */
    public void reverse() {

    }
}
