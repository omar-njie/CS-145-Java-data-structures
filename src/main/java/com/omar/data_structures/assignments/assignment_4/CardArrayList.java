package com.omar.data_structures.assignments.assignment_4;

import com.omar.learn.comparable_interface.Car;

import java.util.Random;

import static com.omar.data_structures.assignments.assignment_4.Card.Cost;

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
            throw new IllegalArgumentException("x must be greater than 0");
        this.cards = new Card[x];
        this.size = 0;
    }


    private void expand() {
        Card[] temp = new Card[this.cards.length * 2];
        for (int i = 0; i < this.cards.length; i++) {
            temp[i] = this.cards[i];
        }
        this.cards = temp;
    }


    @Override
    public String toString() {
        if (this.size == 0) {
            return "[0: :" + this.size + "]";
        }
        // example: [<--: [2,3,4:55],[8,9,10:90],{{{1|1|2:37}},[4,5,6:82] -->4]
        Card c = new Card();
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
        if (this.size == this.cards.length) {
            this.expand();
        }
        this.cards[this.size] = x;
        this.size++;
    }


    @Override
    public Card remove() {
        if (this.size == 0) {
            throw new IllegalStateException("Cannot remove from an empty list");
        }
        Card c = this.cards[this.size - 1];
        this.size--;
        return c;
    }


    @Override
    public Card get(int x) {
        if (x < 0 || x >= this.size) {
            throw new IllegalArgumentException("x must be between 0 and " + (this.size - 1));
        }
        return this.cards[x];
    }


    @Override
    public int indexOf(Card x) {
        for (int i = 0; i < this.size; i++) {
            if (this.cards[i].equals(x)) {
                return i;
            }
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
        this.size++;
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
        this.size--;
        return c;
    }


    @Override
    public void sort() {
        if (this.size == 0) {
            return;
        }
        this.cards = this.merge_sort(this.cards, 0, this.size - 1);
    }


    private Card[] merge_sort(Card[] cards, int left, int right) {
        if (left == right) {
            return new Card[]{cards[left]};
        }
        int mid = (left + right) / 2;
        Card[] left_arr = this.merge_sort(cards, left, mid);
        Card[] right_arr = this.merge_sort(cards, mid + 1, right);
        return this.merge(left_arr, right_arr);
    }

    private Card[] merge(Card[] left_arr, Card[] right_arr) {
        Card[] temp = new Card[left_arr.length + right_arr.length];
        int i = 0, j = 0, k = 0;
        while (i < left_arr.length && j < right_arr.length) {
            if (Cost(left_arr[i].getR(), left_arr[i].getP(), left_arr[i].getS()) <
                    Cost(right_arr[j].getR(), right_arr[j].getP(), right_arr[j].getS())) {
                temp[k] = left_arr[i];
                i++;
            } else {
                temp[k] = right_arr[j];
                j++;
            }
            k++;
        }
        while (i < left_arr.length) {
            temp[k] = left_arr[i];
            i++;
            k++;
        }
        while (j < right_arr.length) {
            temp[k] = right_arr[j];
            j++;
            k++;
        }
        return temp;
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


    private boolean isRoom() {
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
