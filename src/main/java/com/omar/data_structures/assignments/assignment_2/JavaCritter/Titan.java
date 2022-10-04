package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;

/**
 * @author Omar
 * @version 9/29/22
 */
public class Titan extends Giant {

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
