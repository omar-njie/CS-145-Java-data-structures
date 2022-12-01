package com.omar.data_structures.assignments.assignment_6;

/**
 * @author Omar
 * @version 11.27.22
 */
public class Node implements Comparable<Node> {


    public int data;
    public Node left;
    public Node right;
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

    Node(int data) {
        this(data, null, null);
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Frequency: " + frequency + " Value: " + ch;
    }

    public int compareTo(Node o) {
        return this.frequency - o.frequency;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
