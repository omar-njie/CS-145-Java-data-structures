package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;
import java.util.Random;

/**
 * @author Omar
 * @version 9/29/22
 */
public class Giant extends Critter {

    private boolean CowardType;
    private boolean WarriorType;
    private int move_count;
    public Giant() {
        // determines if the Giant is a CowardType(25% chance) or a WarriorType(75% chance).
        Random r = new Random();
        CowardType = r.nextInt(100) < 25;
        WarriorType = r.nextInt(100) < 75;
        move_count = 0;
    }

    @Override
    public Color getColor() {
        return WarriorType ? Color.GRAY : Color.MAGENTA;

    }

    @Override
    public String toString() {
        if (CowardType) {
            if (move_count % 24 < 6) {
                return "fee";
            } else if (move_count % 24 < 12) {
                return "fie";
            } else if (move_count % 24 < 18) {
                return "foe";
            } else {
                return "fum";
            }
        } else {
            if (move_count % 24 < 6) {
                return "FEE";
            } else if (move_count % 24 < 12) {
                return "FIE";
            } else if (move_count % 24 < 18) {
                return "FOE";
            } else {
                return "FUM";
            }
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        move_count++;
        if (info.getFront() == Neighbor.OTHER) {
            if (CowardType) {
                CowardType = false;
                WarriorType = true;
            }
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else if (info.getFront() == Neighbor.WALL) {
            return Action.RIGHT;
        } else {
            return Action.LEFT;
        }
    }
}
