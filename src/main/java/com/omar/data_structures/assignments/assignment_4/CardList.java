package com.omar.data_structures.assignments.assignment_4;

/**
 * This is the interface for a List of cards of any type.   The particular implementation is
 * left to the programmer, but this is a minimal list of possible methods
 *
 * @author Michael A. Wood
 * @version 2.0
 */
/*

public interface CardList {

    */
/**
     * This method should return a representation of the list from index 0 to the final index.
     *
     * @return The string visualization of the list.
     *//*

    String toString();

    */
/**
     * This method should return the current number of elements in the list.
     *
     * @return the size of the list as an integer
     *//*

    int size();

    */
/**
     * This method should add a card to the end of the list in the first available spot.
     *
     * @param c the Card object to be added.
     *//*

    void add(Card c);

    */
/**
     * This method should add a card to the indicated location
     * sliding all other elements over one.
     *
     * @param loc the desired index of the card to be added.
     * @param c   the Card object to be added.
     * @throws IndexOutOfBoundsException if the loc is outside the current list.
     *//*

    void add(int loc, Card c);

    */
/**
     * This method should remove the last element from the list.
     *
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException if the list is empty.
     *//*

    Card remove();

    */
/**
     * This method should remove the identified card from the list and return it.
     *
     * @param loc the index of the card to be removed.
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException if the loc is outside the current array size.
     *//*

    Card remove(int loc);

    */
/**
     * This method should return the i'th last element from the list.
     *
     * @param i The index of the desired card.
     * @return The card object located in index x from the list.
     * @throws IndexOutOfBoundsException if the i value is outside the range of the list
     *//*

    Card get(int i);

    */
/**
     * Returns the index of specified Card object
     *
     * @param c Card object
     * @return index of Card otherwise -1 if not found
     *//*

    int indexOf(Card c);

    */
/**
     * Sort the items in the list from smallest to largest
     *//*

    void sort();

    */
/**
     * Apply a weak shuffle algorithm to rearrange the items in the list.
     *//*

    void shuffle();

    */
/**
     * Empty the list of all items.
     *//*

    void clear();

    */
/**
     * Reverse the list from the first to last element.
     *//*

    void reverse();
*/
}