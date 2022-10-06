package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;

/**
 * The Titan class is a subclass of the {@link Giant} class.
 * It overrides the getColor() method from the Giant class and
 * change the color based on what the Giant class returns if it is a coward or a warrior type.
 *
 * @author Omar
 * @version 10.5.22
 * @see Giant
 */
public class Titan extends Giant {

    /**
     * Creates a Titan object.
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
}
