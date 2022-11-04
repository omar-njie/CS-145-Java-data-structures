package com.omar.data_structures.assignments.assignment_4;

/**
 * @author Omar
 * @version 11/3/22
 */
public class PremiumCard extends Card{

    public PremiumCard() {
        super();
    }


    public PremiumCard(int x) {
        super(x);
    }

    public PremiumCard(int R, int P, int S) {
        super(R, P, S);
    }

    @Override
    public String toString() {
        return "{" + getR() + "/" + getP() + "/" + getS() +
                "::" + Cost(getR(), getP(), getS()) + "}";
    }
}
