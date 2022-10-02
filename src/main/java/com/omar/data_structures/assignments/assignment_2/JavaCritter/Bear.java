package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;
import java.util.Random;

/**
 * @author Omar
 * @version 9/29/22
 */
public class Bear extends Critter {

    private boolean is_normal_bear = true;
    private int move_count;

    public Bear() {
        Random rand = new Random();
        is_normal_bear = rand.nextInt(100) < 50;
        move_count = 0;
        System.out.println("Bear is normal: " + is_normal_bear);
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
