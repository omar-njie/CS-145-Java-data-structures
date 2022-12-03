package com.omar.learn.trees.binary_search_tree.generic_format;

/**
 * @author Omar
 * @version 11/29/22
 */
public class SearchTree<E extends Comparable<E>> {

    private Node<E> root;

    public SearchTree() {
        root = null;
    }

    public void add(E value) {
        root = add(root, value);
    }

    private Node<E> add(Node<E> root, E value) {
        if (root == null) {
            root = new Node<E>(value);
        } else if (value.compareTo(root.data) <= 0) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    public boolean contains(E value) {
        return contains(root, value);
    }

    private boolean contains(Node<E> root, E value) {
        return root != null && (root.data.equals(value) ||
                (value.compareTo(root.data) < 0 ? contains(root.left, value)
                        : contains(root.right, value)));
    }

    public void printSideways() {
        printSideways(root, 0);
    }

    private void printSideways(Node<E> root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

    public void print() {
        print(root);
        System.out.println();
    }

    private void print(Node<E> root) {
        if (root != null) {
            print(root.left);
            System.out.println(root.data);
            print(root.right);
        }
    }

    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this(data, null, null);
        }


        Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
