package com.omar.learn.hashing;

/**
 * @author Omar
 * @version 12/1/22
 */
public class Collision {

    // Collision:
        // When two or more elements values in a hash table
        // produce the same result from the hash function,
        // indicating that they both prefer to be sorted in
        // the same index of the table

    // Probing:
        // Resolving a hash collision by placing elements at other indexes
        // in the table, rather than at the preferred index

    // Linear Probing:
        // Resolving a hash collision by placing elements at the next
        // available index in the table, rather than at the preferred index

    // Separate Chaining:
        // Resolving a hash collision by placing elements in a linked list
        // at the preferred index in the table


    // Adds the given element to this set, if it was not already contained in the set
/*    public void add(int value) {
        if (!contains(value)) {
            // insert new value at the front
            int bucket = hashFunction(value);
            elementData[bucket] = new ListNode(value, elementData[bucket]);
            size++;
        }
    }

    // Returns true if the given value is contained in this set
    public boolean contains(int value) {
        int bucket = hashFunction(value);
        HashEntry current = elementData[bucket];
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;

    }


    // Represents a single value in a chain stored in one hash bucket
    private class HashEntry {
        private int data;
        private HashEntry next;

        public HashEntry(int data) {
            this(data, null);
        }

        public HashEntry(int data, HashEntry next) {
            this.data = data;
            this.next = next;
        }

    }*/
}
