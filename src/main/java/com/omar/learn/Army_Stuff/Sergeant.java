package com.omar.learn.Army_Stuff;

public class Sergeant extends Corporal {

    public Sergeant(String n) {
        super(n);
    }

    public void printResultHelper() {
        if (this.hit()) {
            System.out.println("Sergeant " + getName() + " hits for " + damage() + " points of damage.");
        } else {
            System.out.println("Sergeant " + getName() + " misses");

        }
    }

    public int damage() {
        return super.damage() + 1;
    }
}