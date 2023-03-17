package com.omar.learn.Army_Stuff;

import java.util.Random;

public class Speciialist extends Private {
    public Speciialist(String n) {
        super(n);
    }

    public void printResult() {
        if (this.hit()) {
            System.out.println("Specialist " + getName() + " hits for " + damage() + " points of damage.");
        } else {
            System.out.println("Specialist " + getName() + " misses");

        }
    }

    public boolean hit() {
        Random r = new Random();
        return r.nextInt(100) < 75;
    }
}