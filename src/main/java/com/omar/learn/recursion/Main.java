package com.omar.learn.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Omar
 * @version 10/23/22
 */
public class Main {

    public static void main(String[] args) {
      //  printStars(4);
      //System.out.println(intPow(2, 4));
      //System.out.println(mystery(648));
        // System.out.println(mystery2(348));
    }

    public static void printStars(int n) {
        if (n == 0) {
            System.out.println();
        } else {
            System.out.print("*");
            printStars(n - 1);
        }
    }

    public static int intPow(int x, int y) {
        if (y <= 0) return 1;
        return x * intPow(x, y - 1);
    }

    static int mystery(int n) {
        if (n < 10) {
            return n;
        } else {
            int a = n / 10;
            int b = n % 10;
            return mystery(a + b);
        }
    }



}
