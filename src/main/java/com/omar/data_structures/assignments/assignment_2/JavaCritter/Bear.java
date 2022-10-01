package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;
import java.util.Random;

/**
 * @author Omar
 * @version 9/29/22
 */
public class Bear extends Critter {

    private boolean is_normal_bear;
    private int move_count;

    public Bear() {
        Random random = new Random();
        int chance = random.nextInt(2) + 1;
        is_normal_bear = chance == 1;
        move_count = 0;
    }

    @Override
    public Color getColor() {
        if (is_normal_bear) {
            is_normal_bear = false;
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
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
