package com.omar.learn.trees;

/**
 * @author Omar
 * @version 11/24/22
 */
public class BinaryTree {

    public static void main(String[] args) {

        // Binary Tree:
            //     1 (root)
            //    / \
       // (left) 2   3 (right)
            //  / \ / \
     //        4  5 6  7

        // * an empty tree or a root node that refers
        // to two other trees known as the left subtree and
        // the right subtree.

        // Branch (Branch Node):
            // A node that has one or more nonempty subtrees.

        // Leaf (Leaf Node):
            // A node that has two empty subtrees.

        // Tree Traversal:
            // The process of visiting each node in a tree exactly once.
            // 1. Pre-order Traversal
            // 2. In-order Traversal
            // 3. Post-order Traversal
            //    7
            //   / \
            //  6   5
            // Pre-order Traversal:
                // visits the root, then the left subtree, then the right subtree.
                // yielding the sequence [7, 5,6]
            // In-order Traversal:
                // visits the left subtree, then the root, then the right subtree.
                // yielding the sequence [6, 7, 5]
            // Post-order Traversal:
                // visits the left subtree, then the right subtree, then the root.
                // yielding the sequence [6, 5, 7]
    }

}
