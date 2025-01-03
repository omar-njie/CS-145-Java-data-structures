package com.omar.learn.trees.binary_tree;

import com.omar.learn.trees.binary_tree.IntTree;

/**
 * @author Omar
 * @version 11/24/22
 */
public class IntTreeClient {

    public static void main(String[] args) {

        IntTree tree = new IntTree(12);
        System.out.println("Tree structure:");
        tree.printSideways();
        System.out.println();
        tree.printPreorder();
        tree.printInorder();
        tree.printPostorder();
    }

}
