package com.omar.data_structures.assignments;

import java.util.Random;

/**
 * @author Omar
 * @version 9.21.22
 */
public class Main {

    public int a;
    public char b;
    private String c;

    public Main() {
        c = "Hello";
    }

    public Main(char x) {
        c = "Hello" + x;
        b = x;
    }

    public void print() {
        System.out.println(c);
    }


    public static void main(String[] args) {
       // Main m = new Main();
       // m.print();

        // generate a random number between -6 and 6
        Random r = new Random();
        int x = r.nextInt(12) - 6;
        int y = r.nextInt(12) - 6;
        int z = r.nextInt(12) - 6;
        System.out.println("x: " + x + ", y: " + y + ", z: " + z);
    }
}
