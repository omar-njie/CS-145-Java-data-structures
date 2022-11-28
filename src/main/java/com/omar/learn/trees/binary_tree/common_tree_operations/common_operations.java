package com.omar.learn.trees.binary_tree.common_tree_operations;

import com.omar.learn.trees.binary_tree.IntTreeNode;

/**
 * @author Omar
 * @version 11.27.22
 */
public class common_operations {

    private final IntTreeNode overallRoot;

    public common_operations(IntTreeNode overallRoot) {
        this.overallRoot = overallRoot;
    }

    public int sum() {
        return sum(overallRoot);
    }

    private int sum(IntTreeNode root) {
        if (root == null)
            return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    public int countLevels() {
       return countLevels(overallRoot);
    }

    private int countLevels(IntTreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(countLevels(root.left), countLevels(root.right));
    }

    public int countLeaves() {
        return countLeaves(overallRoot);
    }

    private int countLeaves(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return countLeaves(root.left) + countLeaves(root.right);
        }
    }

}
