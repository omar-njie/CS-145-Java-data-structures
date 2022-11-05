package com.omar.data_structures.assignments.assignment_4;

import java.util.Random;

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
        return element_data.length;
    }


    @Override
    public void add(Card x) {
        if (size == element_data.length)
            expand();
        element_data[size] = x.getR();
        element_data[size] = x.getP();
        element_data[size] = x.getS();
        size += 1;

    }


    @Override
    public Card remove() {
        if (size == 0)
            throw new IllegalStateException("Cannot remove from empty list");
        int temp = element_data[size - 1];
        size -= 1;
        return new Card(temp);
    }


    @Override
    public Card get(int x) {
        if (x < 0 || x >= size)
            throw new IndexOutOfBoundsException("x must be between 0 and " + (size - 1));
        return new Card(element_data[x]);
    }


    @Override
    public int indexOf(Card c) {
        for (int i = 0; i < size; i++) {
            if (element_data[i] == c.getR())
                return i;
        }
        return -1;
    }

    @Override
    public void add(int l, Card x) {
        check_capacity(size + 1);
        if (l < 0 || l > size)
            throw new IndexOutOfBoundsException("Location is outside the bounds of the array");
        for (int i = size; i > l; i--)
            element_data[i] = element_data[i - 1];
        element_data[l] = x.getR();
        element_data[l] = x.getP();
        element_data[l] = x.getS();
        size += 1;
    }

    @Override
    public Card remove(int j) {
        if (j < 0 || j >= size)
            throw new IndexOutOfBoundsException("Location is outside the bounds of the array");
        int temp = element_data[j];
        for (int i = j; i < size - 1; i++)
            element_data[i] = element_data[i + 1];
        size -= 1;
        return new Card(temp);
    }


    @Override
    public void sort() {
        int[] temp = new int[size];
        System.arraycopy(element_data, 0, temp, 0, size);
        merge_sort(temp, 0, size - 1);
        System.arraycopy(temp, 0, element_data, 0, size);
    }


    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < size * 5; i++) {
            int a = rand.nextInt(size);
            int b = rand.nextInt(size);
            swap(a, b);
        }
    }


    private boolean is_room() {
        return size < element_data.length;
    }

    private void swap(int a, int b) {
        int temp = element_data[a];
        element_data[a] = element_data[b];
        element_data[b] = temp;
    }


    public void mystery() {
        int[] temp = new int[size];
        System.arraycopy(element_data, 0, temp, 0, size);
        merge_sort(temp, 0, size - 1);
        reverse(temp);
        System.arraycopy(temp, 0, element_data, 0, size);
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public void reverse() {
        reverse(element_data);
    }

    private void reverse(int[] element_data) {
        for (int i = 0; i < size / 2; i++) {
            swap(i, size - i - 1);
        }
    }


    private void merge_sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int x = mid - start + 1;
        int y = end - mid;

        int[] left = new int[x];
        int[] right = new int[y];

        System.arraycopy(arr, start, left, 0, x);
        System.arraycopy(arr, mid + 1, right, 0, y);

        int i = 0, j = 0;
        int k = start;
        do {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        } while (i < x && j < y);

        while (i < x) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < y) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    private void check_capacity(int capacity) {
        if (capacity > element_data.length) {
            throw new IllegalStateException("exceeded list capacity");
        }
    }

    private void check_index(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
}
