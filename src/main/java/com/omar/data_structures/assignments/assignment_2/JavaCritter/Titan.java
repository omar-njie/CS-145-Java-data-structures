package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;

/**
 * @author Omar
 * @version 9/29/22
 */
public class Titan extends Giant {

    /*
    The titan class is an extension/subclass of the Giant class.   As such it should only have the
    following 3 methods.  Also,  it should have ZERO fields, since it is a subclass of Giant.
        Titan()
        getColor
            Color.BLACK
                When saying “fee” or "FEE"
            COLOR.GRAY
                When saying “fie” or “fum” or the capitalized versions.
            Color.WHITE
                When saying “foe” or "FOE".
            Note that this replaces the color from the Giant Base class.

       Note that the Titan Class should NOT have any other methods, they will be inherited that
       method from the Giant class.
       VERY IMPORTANT
            You should NOT have any private variables in Titan, your goal with this class is
            to have the parent/(Giant) class do all the hard work, and then this class will look
            at the data, and return the new/modified result. You will need to use your superpower here!
    */
    public Titan() {}

    @Override
    public Color getColor() {
        if (super.toString().equals("fee")
                || super.toString().equals("FEE")) {
            return Color.BLACK;
        } else if (super.toString().equals("fie")
                || super.toString().equals("fum")
                || super.toString().equals("FIE")
                || super.toString().equals("FUM")) {
            return Color.GRAY;
        } else {
            return Color.WHITE;
        }
    }

    public static void main(String[] args) {
        Giant g = new Giant();
        Titan t = new Titan();
        for (int i = 0; i < 10; i++) {
            System.out.println(g);
            System.out.println(t);
            System.out.println(g.getColor());
            System.out.println(t.getColor());
            System.out.println("------------------");
        }

    }
}
