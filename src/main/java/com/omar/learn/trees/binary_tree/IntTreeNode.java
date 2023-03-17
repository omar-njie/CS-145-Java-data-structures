package com.omar.learn.trees.binary_tree;

/**
 * @author Omar
 * @version 11/24/22
 */
public class IntTreeNode {

    // class for storing a single node of a binary tree of integers

    public int data;
    public IntTreeNode left;
    public IntTreeNode right;

    // post: constructs a leaf node with given data
    public IntTreeNode(int data) {
        this(data, null, null);
    }

    // post: constructs a branch node with
    // given data, left subtree
    public IntTreeNode(int data, IntTreeNode left,
                       IntTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

