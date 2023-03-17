package com.omar.learn.Army_Stuff;

import java.util.Random;

public class Private implements ArmyDude {
    private final String name;

    public Private(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void printResult() {
        if (this.hit()) {
            System.out.println("Private " + name + " hits for " + damage() + " points of damage.");
        } else {
            System.out.println("Private " + name + " misses");

        }
    }

    public boolean hit() {
        Random r = new Random();
        return r.nextBoolean();
    }

    public int damage() {
        Random r = new Random();
        return r.nextInt(4) + 1;
    }
}