package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;
import java.util.Random;

/**
 * The Giant class is a subclass of the {@link Critter} class.
 * It determines if the giant is a coward or a warrior type.
 *
 * @author Omar
 * @version 9/29/22
 * @see Critter
 */
public class Giant extends Critter {

    private boolean coward_type;
    private boolean warrior_type;
    private int move_count;

    /**
     * Determine if the Giant is a coward or a warrior type
     * For being a warrior type, the Giant must have a 75% chance,
     * and a 25% chance for being a coward type.
     */
    public Giant() {
        Random random_chance = new Random();
        coward_type = random_chance.nextInt(100) < 25; // 25% chance
        warrior_type = random_chance.nextInt(100) < 75; // 75% chance
        move_count = 0;
    }


    @Override
    public Color getColor() {
        return warrior_type ? Color.GRAY : Color.MAGENTA;
    }


    @Override
    public String toString() {
        if (coward_type) {
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
            if (coward_type) {
                coward_type = false;
                warrior_type = true;
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