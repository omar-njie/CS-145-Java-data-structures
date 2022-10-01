package com.omar.data_structures.assignments.assignment_2.JavaCritter;

import java.awt.*;
import java.util.Random;

/**
 * @author Omar
 * @version 9/29/22
 */
public class Lion extends Critter {

    public Lion() {}

    @Override
    public Color getColor() {
        Random rand = new Random();
        int random_color = rand.nextInt(5) + 1;
        return switch (random_color) {
            case 1 -> Color.RED;
            case 2 -> Color.GREEN;
            case 3 -> Color.YELLOW;
            case 4 -> Color.BLUE;
            case 5 -> Color.PINK;
            default -> Color.BLACK;
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
            int random_direction = rand.nextInt(2) + 1;
            return switch (random_direction) {
                case 1 -> Action.LEFT;
                case 2 -> Action.RIGHT;
                default -> Action.HOP;
            };
        } else {
            return Action.HOP;
        }
    }
}
