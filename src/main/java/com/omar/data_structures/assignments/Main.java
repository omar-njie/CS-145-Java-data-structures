package com.omar.data_structures.assignments;

import java.util.Random;

/**
 * @author Omar
 * @version 9.26.22
 */
public class Main {

    public static void main(String[] args) {
        Bird[] birds = new Bird[6];
        birds[0] = new Bird(5, 2, 3, "Eagle");
        birds[1] = new Bird(3, 3, 3, "Hawk");
        birds[2] = new Bird(1, 1, 1, "Finch");
        birds[3] = new Bird(5, 5, 5, "Sparrow");
        birds[4] = new Bird(1, 3, 0, "Humming Bird");
        birds[5] = new Bird();

        int touching = 0;
        int round = 0;
        while (touching < 4) {
            round++;
            System.out.println("Round " + round);
            for (Bird bird : birds) {
                bird.move();
            }
            for (int i = 0; i < birds.length; i++) { // O(n^2)
                for (int j = i + 1; j < birds.length; j++) {
                    if (birds[i].touching(birds[j])) {
                        System.out.println("TOUCH : " + birds[i].getName() + " vs " + birds[j].getName());
                        touching++;
                    }
                }
            }
            for (Bird bird : birds) {
                System.out.println(bird);
            }
            System.out.println("[####################################]");
        }
        System.out.println("There was a total of " + round + " rounds to get to 4 touches.");
    }
}
