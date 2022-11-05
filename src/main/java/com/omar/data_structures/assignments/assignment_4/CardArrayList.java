package com.omar.data_structures.assignments.assignment_4;

/**
 * @author Omar
 * @version 11/3/22
 */
public class CardArrayList implements CardList {

    private int[] element_data;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;

    public CardArrayList() {
        element_data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public CardArrayList(int x) {
        if (x < 1)
            throw new IllegalArgumentException("x must be greater than 0");
        element_data = new int[x];
        size = 0;
    }


    private void expand() {
        int[] temp = new int[element_data.length * 2];
        System.arraycopy(element_data, 0,
                temp, 0, element_data.length);
        element_data = temp;
    }

    /**
     * @see StringBuilder
     */
    @Override
    public String toString() {
        if (size == 0)
            return "[0: :0]";

        StringBuilder sb = new StringBuilder();
        sb.append("[<--: ");
        for (int i = 0; i < size; i++) {
            sb.append(element_data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" -->").append(size).append("]");
        return sb.toString();
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(Card c) {

    }

    @Override
    public void add(int loc, Card c) {

    }

    @Override
    public Card remove() {
        return null;
    }

    @Override
    public Card remove(int loc) {
        return null;
    }

    @Override
    public Card get(int i) {
        return null;
    }

    @Override
    public int indexOf(Card c) {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public void shuffle() {

    }

    @Override
    public void clear() {

    }

    @Override
    public void reverse() {

    }
}
