package com.omar.learn.trees.binary_search_tree;

import com.omar.learn.trees.binary_tree.IntTreeNode;

/**
 * @author Omar
 * @version 11/29/22
 */
public class IntSearchTree {

    private IntTreeNode overallRoot;

    // Binary Search Tree:
        // 1. Properties
            // - left subtree: values must <= root
            // - right subtree: values must > root

    // post: constructs an empty tree
    public IntSearchTree() {
        overallRoot = null;
    }

    // post: value is added to overall tree so as to preserve
    //       binary search tree properties
    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value is added to given tree so as to preserve
    //       binary search tree properties
    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (value <= root.data) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if overall tree contains value
    public boolean contains(int value) {
        return contains(overallRoot, value);
    }

    // post: returns true if given tree contains value
    private boolean contains(IntTreeNode root, int value) {
        return root != null && (root.data == value ||
                (value < root.data ? contains(root.left, value)
                        : contains(root.right, value)));
    }


    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    private void printSideways(IntTreeNode root, int level) {
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
        print(overallRoot);
        System.out.println();
    }

    private void print(IntTreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }
    }

    public int countLeftNodes() {
        return countLeftNodes(overallRoot);
    }

    private int countLeftNodes(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null) {
            return 1 + countLeftNodes(root.left) + countLeftNodes(root.right);
        } else {
            return countLeftNodes(root.right);
        }
    }

}
