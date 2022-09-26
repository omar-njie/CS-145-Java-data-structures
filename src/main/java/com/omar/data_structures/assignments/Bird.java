package com.omar.data_structures.assignments;

import java.util.Random;

/**
 * <h2><b>This Bird class is responsible for moving birds at random points inside the imaginary cube,
 * and checking if two birds are touching each other or if they are at the same location.</b></h2>
 * @author Omar
 * @version 9.26.22
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
        Random rand = new Random();
        // imaginary cube location for x, y, z: [-6, 6]
        this.x = rand.nextInt(12) - 6;
        this.y = rand.nextInt(12) - 6;
        this.z = rand.nextInt(12) - 6;
        this.name = name;

        // check if the inputs are within the constraints
        if (x < -6 || x > 6 || y < -6 || y > 6 || z < -6 || z > 6) {
            this.x = -1;
            this.y = -1;
            this.z = -1;
        }

        // if the name is empty, set it to "Unknown Bird"
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
     * @return <b>true if the birds are touching; false if the birds are on the same location.</b>
     */
    public boolean touching(Bird other) {
        return (this.x == other.x && this.y == other.y && this.z == other.z);
    }


    /**
     * <h2><b>Moves the bird to a random location.</b></h2>
     */
    public void move() {
        Random rand = new Random();
        int direction = rand.nextInt(6);
        int units = rand.nextInt(2) + 1;

        switch (direction) {
            case 0 -> x += units;
            case 1 -> x -= units;
            case 2 -> y += units;
            case 3 -> y -= units;
            case 4 -> z += units;
            case 5 -> z -= units;
        }

        // check if the bird is out of bounds
        if (x < -6) {
            x = 6;
        } else if (x > 6) {
            x = -6;
        }

        if (y < -6) {
            y = 6;
        } else if (y > 6) {
            y = -6;
        }

        if (z < -6) {
            z = 6;
        } else if (z > 6) {
            z = -6;
        }
    }
}