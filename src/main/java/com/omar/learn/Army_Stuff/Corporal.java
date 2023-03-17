package com.omar.learn.Army_Stuff;

import java.util.Random;

public class Corporal implements ArmyDude {
    String name;

    public Corporal(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void printResult() {
        printResultHelper();
        printResultHelper();
    }

    public void printResultHelper() {
        if (this.hit()) {
            System.out.println("Corporal " + getName() + " hits for " + damage() + " points of damage.");
        } else {
            System.out.println("Corporal " + getName() + " misses");

        }
    }

    public boolean hit() {
        Random r = new Random();
        return r.nextInt(100) < 75;
    }

    public int damage() {
        Random r = new Random();
        return r.nextInt(3) + 1;
    }
}