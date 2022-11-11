package com.omar.data_structures.assignments.assignment_4;

import java.util.Random;

/**
 * The Card class is responsible for generating values for R, P and S within the bounds of 1, 1000.
 * This class also calculate the cost, and return the values of R, P, S and the calculated cost.
 * The Card class implements the Comparable interface to compare the cost of two Cards.
 *
 * @author Omar
 * @version 11.10.22
 */
public class Card implements Comparable<Card> {

    private int R, P, S;


    /**
     * Creates a Card object and sets random values for R, P and S
     * are within the constraints of [1, 1000].
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
     *
     * @param x the value to set for R, P and S.
     * @throws IllegalArgumentException if x is not within the constraints of [1, 1000].
     */
    public Card(int x) {
        if (x < 1 || x > 1000)
            throw new IllegalArgumentException("x must be between 1 and 1000");
        R = x;
        P = x;
        S = x;
    }


    /**
     * Creates a Card object and sets the values for R, P and S equal to R, P and S respectively.
     *
     * @param R the value to set for R.
     * @param P the value to set for P.
     * @param S the value to set for S.
     * @throws IllegalArgumentException if R, P or S are not within the constraints of [1, 1000].
     */
    public Card(int R, int P, int S) {
        if (R < 1 && P < 1 && S < 1 ||
                R > 1000 && P > 1000 && S > 1000)
            throw new IllegalArgumentException("R, P, and S must be between 1 and 1000");
        this.R = R;
        this.P = P;
        this.S = S;
    }


    /**
     * Returns the cost of R, P and S.
     * Cost is calculated using this formula: [12/10 * ((R/X)^5 + (P/X)^5 + (S/X)^5)]
     *
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
        return ((int) Math.ceil(cost));
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

    /**
     * @return x the current card, and check if x is the
     * same as R, P and S.
     */
    public boolean equals(Card x) {
        return this.R == x.R && this.P == x.P && this.S == x.S;
    }


    @Override
    public String toString() {
        return "[" + this.R + "," + this.P + "," + this.S
                + "::" + this.getCost() + "]";
    }


    /**
     * <p>Find the smallest R,P amd S and move it closer to 0 by 5.</p>
     * @see Math#min(int a, int b)
     */
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


    /**
     * <p>Find the smallest R,P and move it closer to 1000 by 5.</p>
     * @see Math#min(int a, int b)
     */
    public void boost() {
        // do nothing if they are all the same
        if (this.R == this.P && this.P == this.S)
            return;

        int smallest = Math.min(Math.min(this.R, this.P), this.S);
        if (smallest == this.R) {
            this.R += 5;
        } else if (smallest == this.P) {
            this.P += 5;
        } else {
            this.S += 5;
        }
    }


    /**
     * <p>Compares the cost of two cards.</p>
     *
     * @param o the card to compare to.
     * @return the sum of two cards if they have the same cost.
     * 1 if the cost of this card is greater than the cost of the other card.
     * -1 if the cost of this card is less than the cost of the other card.
     * @see Integer#compare(int x, int y)
     */
    public int compareTo(Card o) {
        if (Cost(this.R, this.S, this.P) == Cost(o.R, o.S, o.P)) {
            return Integer.compare(this.R + this.S + this.P,
                    o.R + o.S + o.P);
        } else if (Cost(this.R, this.S, this.P) >
                Cost(o.R, o.S, o.P)) {
            return 1;
        } else {
            return -1;
        }
    }
}
