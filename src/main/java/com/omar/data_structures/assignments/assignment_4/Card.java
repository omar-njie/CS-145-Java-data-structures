package com.omar.data_structures.assignments.assignment_4;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * @author Omar
 * @version 11/3/22
 */
public class Card implements Comparable<Card> {

    private int R, P, S;

    /**
     * Creates a Card object and sets random values for R, P and S
     * within the constraints of [1, 1000].
     */
    public Card() {
        Random rand = new Random();
        // min 1, max 1000
        int low = 1;
        int high = 1000;
        R = rand.nextInt(high - low) + low + 1;
        P = rand.nextInt(high - low) + low + 1;
        S = rand.nextInt(high - low) + low + 1;

    }


    /**
     * Creates a Card object and sets the values for R, P and S equal to x.
     * @param x the value to set for R, P and S.
     * @throws IllegalArgumentException if x is not within the constraints of [1, 1000].
     */
    public Card(int x) {
        if (x < 1 || x > 1000)
            throw new IllegalArgumentException(
                    "x must be between 1 and 1000");
        R = x;
        P = x;
        S = x;
    }


    /**
     * Creates a Card object and sets the values for R, P and S equal to R, P and S respectively.
     * @param R the value to set for R.
     * @param P the value to set for P.
     * @param S the value to set for S.
     * @throws IllegalArgumentException if R, P or S is not within the constraints of [1, 1000].
     */
    public Card(int R, int P, int S) {
        if (R < 1 && P < 1 && S < 1 || R > 1000 && P > 1000 && S > 1000)
            throw new IllegalArgumentException(
                    "R, P, and S must be between 1 and 1000");
        this.R = R;
        this.P = P;
        this.S = S;
    }


    /**
     * Returns the cost of R, P and S.
     * Cost is calculated using this formula: [12/10 * ((R/X)^5 + (P/X)^5 + (S/X)^5)]
     * @param R the value of R.
     * @param P the value of P.
     * @param S the value of S.
     * @return the cost of R, P and S.
     */
    public static int Cost(int R, int P, int S) {
        int X = R + P + S;
        double cost = 12 / (10 * ((Math.pow((double) R / (double) X, 5))
                + (Math.pow((double) P / (double) X, 5))
                + (Math.pow((double) S / (double) X, 5))));
        return Math.toIntExact(Math.round(cost));
    }


    /**
     * @return R value.
     */
    public int getR() {
        return R;
    }


    /**
     * @return P value.
     */
    public int getP() {
        return P;
    }


    /**
     * @return S value.
     */
    public int getS() {
        return S;
    }


    /**
     * @return the cost of R, P and S.
     */
    public int getCost() {
        return Cost(this.R, this.P, this.S);
    }



    public boolean equals(Card x) {
        return this.R == x.R && this.P == x.P && this.S == x.S;
    }


    @Override
    public String toString() {
        return "[" + this.R + "," + this.P + "," + this.S +
                "::" + this.getCost() + "]";
    }


    public void weaken() {
        int smallest = Math.min(Math.min(this.R, this.P), this.S);
        if (smallest == this.R) {
            this.R -= 5;
        } else if (smallest == this.P) {
            this.P -= 5;
        } else {
            this.S -= 5;
        }
    }

    public void boost() {
        int smallest = Math.min(Math.min(this.R, this.P), this.S);
        if (smallest == this.R) {
            this.R += 5;
        } else if (smallest == this.P) {
            this.P += 5;
        } else {
            this.S += 5;
        }

        if (this.R == this.P && this.P == this.S) {
            return;
        }
    }

    
    @Override
    public int compareTo(@NotNull Card o) {
        if (Cost(this.R, this.S, this.P) == Cost(o.R, o.S, o.P)) {
            if (this.R + this.S + this.P == o.R + o.S + o.P) {
                return 0;
            } else if (this.R + this.S + this.P > o.R + o.S + o.P) {
                return 1;
            } else {
                return -1;
            }
        } else if (Cost(this.R, this.S, this.P) > Cost(o.R, o.S, o.P)) {
            return 1;
        } else {
            return -1;
        }
    }
}
