package com.omar.data_structures.assignments;

import java.util.Random;

/**
 * <h2><p>
 * The main class create Bird objects and print out the total number of rounds
 * for the birds that gets to touch 4 times.
 * </p></h2>
 *
 * @author Omar
 * @version 9.26.22
 */
public class Main {

    public static void main(String[] args) {
        Bird[] birds = new Bird[6];
        Random rand = new Random();
        int x = rand.nextInt(13) - 6;
        int y = rand.nextInt(13) - 6;
        int z = rand.nextInt(13) - 6;
        Bird b = new Bird(x, y, z, "");

        birds[0] = new Bird(5, 2, 3, "Eagle");
        birds[1] = new Bird(3, 3, 3, "Hawk");
        birds[2] = new Bird(1, 0, -1, "Finch");
        birds[3] = new Bird(b.getX(), b.getY(), b.getZ(), "Sparrow");
        birds[4] = new Bird(b.getX(), b.getY(), b.getZ(), "Humming Bird");
        birds[5] = new Bird();


        int touching = 0;
        int round = 0;
        while (touching < 4) {
            round++;
            System.out.println("Round " + round);
            for (Bird bird : birds) {
                bird.move();
            }
            for (int i = 0; i < birds.length; i++) {
                for (int j = i + 1; j < birds.length; j++) {
                    if (birds[i].touching(birds[j])) {
                        System.out.println("TOUCH : " + birds[i].getName()
                                + " vs " + birds[j].getName());
                        touching++;
                    }
                }
            }
            for (Bird bird : birds) {
                System.out.println(bird);
            }
            System.out.println("[####################################]");
        }
        System.out.println("There was a total of " + round +
                " rounds to get to 4 touches.");
    }
}
