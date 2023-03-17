package com.omar.learn.generics;

/**
 * @author Omar
 * @version 11/16/22
 */
public class Car extends Vehicle {

    private int doors;

    public Car(String make, String model, int year, int doors) {
        super(make, model, year);
        this.doors = doors;
    }

    public String toString() {
        return super.toString() + " " + doors;
    }

}
