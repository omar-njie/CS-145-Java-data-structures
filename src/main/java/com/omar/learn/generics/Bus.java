package com.omar.learn.generics;

/**
 * @author Omar
 * @version 11/16/22
 */
public class Bus extends Vehicle {

    private int capacity;

    public Bus(String make, String model, int year, int capacity) {
        super(make, model, year);
        this.capacity = capacity;
    }

    public String toString() {
        return super.toString() + " " + capacity;
    }

}