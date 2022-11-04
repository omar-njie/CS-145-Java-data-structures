package com.omar.data_structures.assignments.assignment_4;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * @author Omar
 * @version 11/3/22
 */
public class Card implements Comparable<Card> {

    private int R, S, P;

    public Card() {
        Random rand = new Random();
        // min 1, max 1000
        int low = 1;
        int high = 1000;
        R = rand.nextInt(high - low) + low + 1;
        S = rand.nextInt(high - low) + low + 1;
        P = rand.nextInt(high - low) + low + 1;

    }

    public int Cost(int cost) {
        int X = R + S + P;
        // [12/10 * ((R/X)^5 + (S/X)^5 + (P/X)^5)]
        int f = (int) (12 / 10 * ((Math.pow(R / X, 5)) + (Math.pow(S / X, 5)) + (Math.pow(P / X, 5))));

        return Math.round(cost);


    }

    @Override
    public int compareTo(@NotNull Card o) {
        return 0;
    }
}
