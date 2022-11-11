package com.omar.data_structures.assignments.assignment_4;

/**
 * The Premium Card class is a subclass of the {@link Card} class.
 * The Premium Card class do the same thing as the {@link Card} class, but it overrides
 * the {@link Card#toString()} method to return the values of R, P, S and the calculated cost
 * with this representation for premium cards {R/P/S::Cost} instead of this representation
 * [R,P,S::Cost] for normal cards.
 *
 * @see Card
 * @author Omar
 * @version 11.10.22
 */
public class PremiumCard extends Card {


    /**
     * Creates a Premium Card object and sets random values for R, P and S
     * within the constraints of [1, 1000].
     */
    public PremiumCard() {
        super();
    }


    /**
     * Creates a Premium Card object and sets the values for R, P and S equal to x.
     *
     * @param R the value to set for R.
     * @param P the value to set for P.
     * @param S the value to set for S.
     * @throws IllegalArgumentException if R, P or S are not within the constraints of [1, 1000].
     */
    public PremiumCard(int R, int P, int S) {
        super(R, P, S);
    }


    @Override
    public String toString() {
        return "{" + getR() + "/" + getP() + "/" + getS() +
                "::" + Cost(getR(), getP(), getS()) + "}";
    }
}
