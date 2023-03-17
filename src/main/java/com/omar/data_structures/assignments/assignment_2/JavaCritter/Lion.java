package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;
import java.util.Random;

/**
 * The Lion class is a subclass of the {@link Critter} class.
 * It assigns the lion a random color for every five moves.
 *
 * @author Omar
 * @version 10.5.22
 * @see Critter
 */
public class Lion extends Critter {

    private int move_count;
    private int random_color;

    /**
     * Creates a lion object.
     */
    public Lion() {}


    @Override
    public Color getColor() {
        Random rand = new Random();
        if (move_count % 5 == 0) {
            rand.nextInt(5);
            int next;
            do {
                next = rand.nextInt(5);
            } while (next == random_color);
            random_color = next;
        }
        return switch (random_color) {
            case 0 -> Color.RED;
            case 1 -> Color.GREEN;
            case 2 -> Color.YELLOW;
            case 3 -> Color.BLUE;
            case 4 -> Color.PINK;
            default -> null;
        };
    }


    @Override
    public String toString() {
        return "L";
    }


    @Override
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL
                || info.getFront() == Neighbor.SAME) {
            Random rand = new Random();
            boolean random_direction = rand.nextInt(100) < 50;
            return random_direction ? Action.LEFT : Action.RIGHT; // 50% chance to turn left or right
        } else {
            return Action.HOP;
        }
    }
}
