package com.omar.data_structures.assignments.assignment_4;

import java.util.Random;

/**
 * @author Omar
 * @version 11/3/22
 */
public class CardArrayList implements CardList {

    private Card[] cards;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;


    public CardArrayList() {
        this.cards = new Card[DEFAULT_CAPACITY];
        this.size = 0;
    }


    public CardArrayList(int x) {
        if (x < 1)
            throw new IllegalArgumentException(
                    "x must be greater than 0");
        this.cards = new Card[x];
        this.size = 0;
    }


    private void expand() {
        Card[] temp = new Card[this.cards.length * 2];
        System.arraycopy(this.cards, 0, temp, 0, this.cards.length);
        this.cards = temp;
    }


    @Override
    public String toString() {
        if (this.size == 0)
            return "[0: :" + this.size + "]";

        StringBuilder sb = new StringBuilder();
        sb.append("[<--: ");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.cards[i].toString());
            if (i != this.size - 1) {
                sb.append(",");
            }
        }
        sb.append(" -->").append(this.size).append("]");
        return sb.toString();
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(Card x) {
        if (this.size == this.cards.length)
            this.expand();
        this.cards[this.size] = x;
        this.size += 1;
    }


    @Override
    public Card remove() {
        if (this.size == 0) {
            throw new IllegalStateException(
                    "Cannot remove from an empty list");
        }
        Card c = this.cards[this.size - 1];
        this.size -= 1;
        return c;
    }


    @Override
    public Card get(int x) {
        if (x < 0 || x >= this.size) {
            throw new IllegalArgumentException(
                    "x must be between 0 and " + (this.size - 1)
            );
        }
        return this.cards[x];
    }


    @Override
    public int indexOf(Card x) {
        for (int i = 0; i < this.size; i++) {
            if (this.cards[i].equals(x))
                return i;
        }
        return -1;
    }


    @Override
    public void add(int l, Card x) {
        check_capacity(size + 1);
        if (l < 0 || l > this.size) {
            throw new IllegalArgumentException("l must be between 0 and " + this.size);
        }
        if (this.size == this.cards.length) {
            this.expand();
        }
        for (int i = this.size; i > l; i--) {
            this.cards[i] = this.cards[i - 1];
        }
        this.cards[l] = x;
        this.size += 1;
    }


    @Override
    public Card remove(int j) {
        if (j < 0 || j >= this.size) {
            throw new IllegalArgumentException("j must be between 0 and " + (this.size - 1));
        }
        Card c = this.cards[j];
        for (int i = j; i < this.size - 1; i++) {
            this.cards[i] = this.cards[i + 1];
        }
        this.size -= 1;
        return c;
    }

    @Override
    public void sort() {
        Card[] temp = new Card[this.size];
        System.arraycopy(this.cards, 0, temp, 0, this.size);
        merge_sort(temp, 0, this.size - 1);
        System.arraycopy(temp, 0, this.cards, 0, this.size);
    }

    private void merge_sort(Card[] cards, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(cards, start, mid);
            merge_sort(cards, mid + 1, end);
            merge(cards, start, mid, end);
        }
    }


    private void merge(Card[] cards, int start, int mid, int end) {
        int x = mid - start + 1;
        int y = end - mid;

        Card[] left = new Card[x];
        Card[] right = new Card[y];

        System.arraycopy(cards, start, left, 0, x);
        System.arraycopy(cards, mid + 1, right, 0, y);

        int i = 0, j = 0, k = start;
        do {
            if (left[i].compareTo(right[j]) < 0) {
                cards[k] = left[i];
                i++;
            } else {
                cards[k] = right[j];
                j++;
            }
            k++;
        } while (i < x && j < y);

        while (i < x) {
            cards[k] = left[i];
            i++;
            k++;
        }

        while (j < y) {
            cards[k] = right[j];
            j++;
            k++;
        }
    }

    @Override
    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < this.size * 5; i++) {
            int x = rand.nextInt(this.size);
            int y = rand.nextInt(this.size);
            Card c = this.cards[x];
            this.cards[x] = this.cards[y];
            this.cards[y] = c;
        }
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public void reverse() {
        for (int i = 0; i < this.size / 2; i++) {
            Card c = this.cards[i];
            this.cards[i] = this.cards[this.size - i - 1];
            this.cards[this.size - i - 1] = c;
        }
    }


    private boolean is_room() {
        return this.size < this.cards.length;
    }


    private void swap(int a, int b) {
        Card c = this.cards[a];
        this.cards[a] = this.cards[b];
        this.cards[b] = c;
    }

    public void mystery() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size - 1; j++) {
                if (this.cards[j].compareTo(this.cards[j + 1]) > 0) {
                    this.swap(j, j + 1);
                }
            }
        }
    }

    private void check_capacity(int capacity) {
        if (capacity > cards.length) {
            throw new IllegalStateException("exceeded list capacity");
        }
    }

    private void check_index(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index must be between 0 and " + (size - 1));
        }
    }


}
