package com.omar.learn.generics;

/**
 * @author Omar
 * @version 11/16/22
 */
public class Printer<T extends Vehicle> {

    T thingToPrint;

    public Printer(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        System.out.println(thingToPrint);
    }
}
