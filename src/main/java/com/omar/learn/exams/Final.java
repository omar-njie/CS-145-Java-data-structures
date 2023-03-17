package com.omar.learn.exams;

import com.omar.learn.trees.binary_tree.IntTreeNode;

/**
 * @author Omar
 * @version 12.8.22
 */
public class Final {

    private IntTreeNode root;


    public static void main(String[] args) {

        System.out.println(recursive2Power(2));

    }

    // recursion
    static int recursive2Power(int x) {
        if (x < 0) {
            System.out.println("error");
            return 0;
        }
        if (x == 0)
            return 1;
        return 2 * recursive2Power(x - 1);
    }

    // trees
    public void trim(int min, int max) {
       if (root == null) return;
       root = trim(min, max , root);
    }

    private IntTreeNode trim(int min, int max, IntTreeNode root) {
        if (root == null)
            return null;

        if (root.data < min)
            return trim(min, max, root.right);
        if (root.data > max)
            return trim(min, max, root.left);

        root.left = trim(min, max, root.left);
        root.right = trim(min, max, root.right);
        return root;
    }

    // Linked Lists
    public void removeDuplicates() {
        if (front == null) return;
        ListNode current = front;
        while (current.next != null) {
            if (current.data == current.next.data)
                current.next = current.next.next;
            else
                current = current.next;
        }
    }

   /* public void remove2nd() {
        IntTreeNode temp = frontNode;
        IntTreeNode beforeTemp;
        if (temp == null) return;
        if (temp.next == null) return;
        while (temp.next.next != null) {
            beforeTemp = temp;
            temp = temp.next;
        }
        beforeTemp.next = temp.next;
        // For DLL add the next line
        // beforetemp.next.previous = beforeTemp;
    }*/




    }
