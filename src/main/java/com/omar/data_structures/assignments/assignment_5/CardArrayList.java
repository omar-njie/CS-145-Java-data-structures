package com.omar.data_structures.assignments.assignment_5;

import java.util.Random;

/**
 * The CardArrayList class implements the {@link CardList} interface.
 * It implements this following methods:
 * <ul>
 *     <li>{@link CardList#toString()}</li>
 *     <li>{@link CardList#size()}</li>
 *     <li>{@link CardList#add(Card)}</li>
 *     <li>{@link CardList#add(int, Card)}</li>
 *     <li>{@link CardList#remove()}</li>
 *     <li>{@link CardList#remove(int)}</li>
 *     <li>{@link CardList#get(int)}</li>
 *     <li>{@link CardList#indexOf(Card)}</li>
 *     <li>{@link CardList#sort()}</li>
 *     <li>{@link CardList#shuffle()}</li>
 *     <li>{@link CardList#clear()}</li>
 *     <li>{@link CardList#reverse()}</li>
 * </ul>
 * The class has some additional helper methods such as {@link CardArrayList#expand()},
 * {@link CardArrayList#swap(int, int)}, {@link CardArrayList#is_room()},
 * and {@link CardArrayList#check_capacity(int)},
 * {@link CardArrayList#check_index(int)}.
 * It also implements the merge sort algorithm; {@link CardArrayList#sort()},
 * {@link CardArrayList#merge_sort(Card[], int, int)},
 * {@link CardArrayList#merge(Card[], int, int, int)} to sort the list from least to greatest,
 * and a {@link CardArrayList#mystery()} method to reverse the previous sorted list from greatest to least.
 *
 * @see StringBuilder
 * @author Omar
 * @version 11.10.22
 */
public class CardArrayList implements CardList {

    public static final int DEFAULT_CAPACITY = 10;
    private Card[] card_list_data;
    private int size;


    /**
     * Creates a CardArrayList object and sets the size to 0.
     */
    public CardArrayList() {
        this.card_list_data = new Card[DEFAULT_CAPACITY];
        this.size = 0;
    }


    /**
     * Creates a CardArrayList object and sets the size to 0.
     *
     * @param x the initial size of the CardArrayList.
     */
    public CardArrayList(int x) {
        if (x < 1)
            throw new IllegalArgumentException("x must be greater than 0");
        this.card_list_data = new Card[x];
        this.size = 0;
    }


    private void expand() {
        Card[] temp = new Card[this.card_list_data.length * 2]; // expand the array by 2 times
        System.arraycopy(this.card_list_data, 0, temp, 0, this.card_list_data.length);
        this.card_list_data = temp;
    }


    @Override
    public String toString() {
        if (this.size == 0)
            return "[0: :" + this.size + "]";

        StringBuilder sb = new StringBuilder();
        sb.append("[<--: ");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.card_list_data[i].toString());
            if (i != this.size - 1)
                sb.append(",");
        }
        sb.append(" -->").append(this.size).append("]");
        return sb.toString();
    }

    /**
     * @return the size of the list as an integer
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
        if (!(is_room())) expand();
        this.card_list_data[this.size] = x;
        this.size += 1;
    }


    /**
     * Remove the last element from the list.
     *
     * @return The card object removed from the list.
     * @throws IllegalStateException if the list is empty.
     */
    public Card remove() {
        if (this.size == 0)
            throw new IllegalStateException("Cannot remove from an empty list");

        Card c = this.card_list_data[this.size - 1];
        this.size -= 1;
        return c;
    }

    /**
     * Return the i'th last element from the list.
     *
     * @param x The index of the desired card.
     * @return The card object located in index x from the list.
     * @throws IndexOutOfBoundsException if x {@code (x < 0 || x >= this.size) {}}
     *                                   is outside the current list.
     */
    public Card get(int x) {
        check_index(x);
        return this.card_list_data[x];
    }

    /**
     * Returns the index of specified Card object
     *
     * @param x Card object
     * @return index of Card otherwise -1 if not found
     */
    public int indexOf(Card x) {
        for (int i = 0; i < this.size; i++) {
            if (this.card_list_data[i].equals(x))
                return i;
        }
        return -1;
    }

    /**
     * Add a card to the indicated location
     * sliding all other elements over one.
     *
     * @param l the desired index of the card to be added.
     * @param x the Card object to be added.
     * @throws IndexOutOfBoundsException if l {@code (l < 0 || l >= this.size) {}} is outside the current list.
     */
    public void add(int l, Card x) {
        if (!(is_room())) expand();
        for (int i = this.size; i > l; i--)
            this.card_list_data[i] = this.card_list_data[i - 1];

        this.card_list_data[l] = x;
        this.size += 1;
    }

    /**
     * Remove the identified card from the list and return it.
     *
     * @param j the index of the card to be removed.
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException if j {@code (j < 0 || j >= this.size) {}}
     *                                   is outside the current list.
     */
    public Card remove(int j) {
        check_index(j);

        Card c = this.card_list_data[j];
        for (int i = j; i < this.size - 1; i++)
            this.card_list_data[i] = this.card_list_data[i + 1];

        this.size -= 1;
        return c;
    }

    /**
     * Sort the items in the list from smallest to largest
     *
     * @see System#arraycopy(Object, int, Object, int, int)
     */
    public void sort() {
        Card[] temp = new Card[this.size];
        System.arraycopy(this.card_list_data, 0, temp, 0, this.size);
        merge_sort(temp, 0, this.size - 1);
        System.arraycopy(temp, 0, this.card_list_data, 0, this.size);
    }


    private void merge_sort(Card[] card_arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2; // Find the middle point
            merge_sort(card_arr, start, mid);
            merge_sort(card_arr, mid + 1, end);
            merge(card_arr, start, mid, end);
        }
    }


    private void merge(Card[] card_arr, int start, int mid, int end) {
        int x = mid - start + 1;
        int y = end - mid;

        Card[] left = new Card[x];
        Card[] right = new Card[y];

        // Copy data to temp arrays
        System.arraycopy(card_arr, start, left, 0, x);
        System.arraycopy(card_arr, mid + 1, right, 0, y);

        int i = 0, j = 0, k = start;
        do {
            if (left[i].compareTo(right[j]) < 0) {
                card_arr[k] = left[i];
                i += 1;
            } else {
                card_arr[k] = right[j];
                j += 1;
            }
            k += 1;
        } while (i < x && j < y);

        while (i < x) {
            card_arr[k] = left[i];
            i += 1;
            k += 1;
        }

        while (j < y) {
            card_arr[k] = right[j];
            j += 1;
            k += 1;
        }
    }


    /**
     * Shuffle the items in the list.
     */
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < this.size * 5; i++) {
            int x = rand.nextInt(this.size);
            int y = rand.nextInt(this.size);
            Card c = this.card_list_data[x];
            this.card_list_data[x] = this.card_list_data[y];
            this.card_list_data[y] = c;
        }
    }

    /**
     * Empty the list of all items.
     */
    public void clear() {
        this.size = 0;
    }

    /**
     * Reverse the list from the first to last element.
     *
     * @see CardArrayList#swap(int a, int b)
     */
    public void reverse() {
        for (int i = 0; i < this.size / 2; i++) {
            swap(i, this.size - i - 1);
        }
    }


    // Helper method to check if there is enough room in the array
    private boolean is_room() {
        return this.size < this.card_list_data.length;
    }


    private void swap(int a, int b) {
        Card c = this.card_list_data[a];
        this.card_list_data[a] = this.card_list_data[b];
        this.card_list_data[b] = c;
    }


    /**
     * <p>Get the previous sorted cards form greatest to smallest.</p>
     */
    public void mystery() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size - 1; j++) {
                if (this.card_list_data[j].compareTo(this.card_list_data[j + 1]) > 0) {
                    this.swap(j, j + 1);
                }
            }
        }
    }


    // Helper method to check if the array is full
    private void check_capacity(int capacity) {
        if (capacity > card_list_data.length) {
            throw new IllegalStateException("exceeded list capacity");
        }
    }


    // Helper method to check if the index is valid
    private void check_index(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
}
