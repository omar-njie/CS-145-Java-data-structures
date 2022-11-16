package com.omar.learn.implement_collections.array_list;

/**
 * @author Omar
 * @version 11/4/22
 */
public class ArrayIntList {

    private final int[] elementData;
    private int size;
    public static final int DEFAULT_CAPACITY = 100;

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    public ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public void add(int value) {
        checkCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    // pre : 0 <= index < size()
    // post: returns the integer of the size of the list
    public int getSize() {
        return size;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return elementData[index];
    }

    // post: returns the index of the first occurrence of the
    //       given value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index, shifting subsequent
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    // pre : size() < capacity && 0 <= index <= size()
    // post: inserts the given value at the given index, shifting
    //       subsequent values right
    public void add(int index, int value) {
        checkCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // post: returns comma-separated, bracketed version of list
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder("[" + elementData[0]);
            for (int i = 1; i < size; i++) {
                result.append(", ").append(elementData[i]);
            }
            result.append("]");
            return result.toString();
        }
    }

    private void checkCapacity(int capacity) {
        if (capacity > elementData.length) {
            throw new IllegalStateException("exceeded list capacity");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
}
