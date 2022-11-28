package com.omar.learn.trees.binary_tree.common_tree_operations;

import com.omar.learn.trees.binary_tree.IntTreeNode;

/**
 * @author Omar
 * @version 11.27.22
 */
public class Main {

    public static void main(String[] args) {

        common_operations tree = new common_operations(
                new IntTreeNode(1, new IntTreeNode(2,
                new IntTreeNode(4),
                new IntTreeNode(5)),
                new IntTreeNode(3, new IntTreeNode(6),
                        new IntTreeNode(7))));
        System.out.println(tree.sum()); // 28
        System.out.println(tree.countLevels()); // 3
        System.out.println(tree.countLeaves()); // 4
    }

}
