package com.omar.algorithms.learn;

/**
 * @author Omar
 * @version 11/2/22
 */
public class BinarySearchEx {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;
        int result = binary_search(arr, target, 0, arr.length - 1);
        System.out.println(result);
    }


    public static int binary_search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binary_search(arr, target, start, mid - 1);
        } else {
            return binary_search(arr, target, mid + 1, end);
        }
    }
}
