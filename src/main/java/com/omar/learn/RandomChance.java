package com.omar.learn;

import java.util.Random;

/**
 * @author Omar
 * @version 9/29/22
 */
public class RandomChance {

    public static void main(String[] args) {

        Random rand = new Random();
        int rand_num;
        for (int i = 0; i < 5; i++) {
            rand_num = rand.nextInt(5) + 1;
            System.out.print(rand_num + " ");
        }
        // do not pick the same number in a row

    }

}
