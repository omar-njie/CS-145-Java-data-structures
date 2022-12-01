package com.omar.data_structures.assignments.assignment_6;

/**
 * @author Omar
 * @version 11.27.22
 */
public class Node<E extends Comparable<E>> {


    E data;
    Node<E> left;
    Node<E> right;
    Integer frequency;
    Character ch;

    Node(Integer frequency, Character ch) {
        this.frequency = frequency;
        this.ch = ch;
    }

    Node() {
        this.frequency = null;
        this.ch = null;
    }

    Node(E data) {
        this(data, null, null);
    }

    Node(E data, Node<E> left, Node<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Frequency: " + frequency + " Value: " + ch;
    }

    public int compareTo(Node<E> o) {
        return this.frequency - o.frequency;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
