package com.omar.learn.trees.binary_tree;

public class IntTree {

    private final IntTreeNode overallRoot;


        //     1 (root)
        //    / \
    //(left) 2   3 (right)
        //  / \ / \
        //  4  5 6  7

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

    // pre: max > 0 (throws IllegalArgumentException if not)
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                    buildTree(2 * n + 1, max));
        }
    }

    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.println("Preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the in pre-order the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: print the tree contents using an inorder traversal
    public void printInorder() {
        System.out.println("Inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints the in in-order the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    // post: prints the tree contents, using a post-order traversal
    public void printPostorder() {
        System.out.println("Postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
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
            print(overallRoot.left);
            System.out.println(overallRoot.data + " ");
            print(overallRoot.right);
        }
    }
}
