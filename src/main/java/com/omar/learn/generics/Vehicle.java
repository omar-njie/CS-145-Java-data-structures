package com.omar.learn.generics;

/**
 * @author Omar
 * @version 11/16/22
 */
public class Vehicle {

    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String toString() {
        return make + " " + model + " " + year;
    }

}
