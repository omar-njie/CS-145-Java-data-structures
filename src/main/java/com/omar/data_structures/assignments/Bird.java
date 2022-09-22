package com.omar.data_structures.assignments;

import java.util.Random;

/**
 *
 * @author Omar
 * @version 9.21.22
 */
public class Bird {

    private int x, y, z;
    private String name;

    // Default constructor
    public Bird() {
        x = 1;
        y = 1;
        z = 1;
        name = "Unknown Bird";
    }

    public Bird(int x, int y, int z, String name) {
        Random r = new Random();
        // imaginary cube location for x, y, z: [-6, 6]
        this.x = x + r.nextInt(12) - 6;
        this.y = y + r.nextInt(12) - 6;
        this.z = z + r.nextInt(12) - 6;
        this.name = name;

        // check if the inputs are within the constraints
        if (x < -6 || x > 6 || y < -6 || y > 6 || z < -6 || z > 6) {
            this.x = -1;
            this.y = -1;
            this.z = -1;
        }
        if (name == null || name.equals("")) {
            this.name = "Unknown Bird";
        }
    }

    /**
     * @return x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * @return y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * @return z coordinate.
     */
    public int getZ() {
        return z;
    }

    /**
     * @return name of the bird.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " is at " + x + ", " + y + ", " + z;
    }

    /**
     * @param other the bird to compare to.
     * @return true if the birds are touching; false if the birds are on the same location.
     */
    public boolean touching(Bird other) {
        return (this.x == other.x && this.y == other.y && this.z == other.z);
    }

    public void move() {
        Random r = new Random();
        int direction = r.nextInt(6);
        int units = r.nextInt(2) + 1;
        switch (direction) {
            case 0 -> {
                x += units;
                if (x > 6) {
                    x = -6 + (x - 6);
                }
            }
            case 1 -> {
                x -= units;
                if (x < -6) {
                    x = 6 - (x + 6);
                }
            }
            case 2 -> {
                y += units;
                if (y > 6) {
                    y = -6 + (y - 6);
                }
            }
            case 3 -> {
                y -= units;
                if (y < -6) {
                    y = 6 - (y + 6);
                }
            }
            case 4 -> {
                z += units;
                if (z > 6) {
                    z = -6 + (z - 6);
                }
            }
            case 5 -> {
                z -= units;
                if (z < -6) {
                    z = 6 - (z + 6);
                }
            }
        }
    }

    /*
        Create an array that can hold 6 birds.
o Fill the array with 3 birds with names and locations of your choice.
▪ Not the users choice,   your choice as the programmer.
o Fill the array with 2 named birds but with random locations.
o Finish filling the array with one default bird.
• Create a touching counter that starts at zero and a round counter.
• Print out the starting locations and names of all the animals.
• Then do the following loop.
o Print out the round number.
o Move all the birds randomly.
o Check all the birds to see if any of them are on the same spot.
▪ Make sure to check for touching animals AFTER moving all the animals.
o If any of the birds are touching it should print out the word “TOUCHING” to the
screen and show the names of the two animals that are touching.
▪ Note if A is touching B, do NOT also print that B is touching A.  Each touch
should only be printed once.
o Print out the current locations and names of all birds.
o Print a line "[####################################]" between each
round of the movement.
• Repeat the loop above until there are at least 4 touches.
• Print out the total number of fights.
O This will probably be 4 but might be larger IF there were multiple touches on the
last round.
• Print out the total number of rounds that it took to get to 4 touches.
Before submitting your assignment, make sure your program is correctly Java Documented and
is listed as your name as the author.
Make sure to check that x , y, and z are inside the box at all times,  don’t allow it to start outside
the map, or move outside the map.
S AMPLE OUT PUT


Eagle is at 5, 2, 3
Hawk is at 3, 3, 3
Finch is at 1, 1, 1
    */
    public static void main(String[] args) {
        Bird[] birds = new Bird[6];
        birds[0] = new Bird(1, 1, 1, "Finch");
        birds[1] = new Bird(3, 3, 3, "Hawk");
        birds[2] = new Bird(5, 2, 3, "Eagle");
        birds[3] = new Bird();
        birds[4] = new Bird();
        birds[5] = new Bird();

        int touches = 0;
        int rounds = 0;
        while (touches < 4) {
            System.out.println("Round " + rounds);
            for (Bird bird : birds) {
                bird.move();
                System.out.println(bird);
            }
            for (int i = 0; i < birds.length; i++) {
                for (int j = i + 1; j < birds.length; j++) {
                    if (birds[i].touching(birds[j])) {
                        System.out.println("TOUCHING: " + birds[i].getName() + " and " + birds[j].getName());
                        touches++;
                    }
                }
            }
            System.out.println("[####################################]");
            rounds++;
        }
        System.out.println("Total number of touches: " + touches);
        System.out.println("Total number of rounds: " + rounds);
    }
}
