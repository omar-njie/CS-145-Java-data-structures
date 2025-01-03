package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;
import java.util.Random;

/**
 * The Bear class is a subclass of the {@link Critter} class.
 * It checks if the bear is a normal or a polar bear.
 *
 * @author Omar
 * @version 10.5.22
 * @see Critter
 */
public class Bear extends Critter {

    private final boolean is_normal_bear;
    private int move_count;

    /**
     * Decide whether the bear is a normal bear or a polar bear
     * There is a 50% that the bear could be normal or polar
     */
    public Bear() {
        Random rand = new Random();
        is_normal_bear = rand.nextInt(100) < 50;
        move_count = 0;
    }


    @Override
    public Color getColor() {
        return !(is_normal_bear) ? Color.WHITE : Color.BLACK;
    }


    @Override
    public String toString() {
        if (move_count % 2 == 0) {
            return "/";
        } else {
            return "\\";
        }
    }


    @Override
    public Action getMove(CritterInfo info) {
        move_count++;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
}
