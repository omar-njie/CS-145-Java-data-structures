package com.omar.data_structures.assignments.assignment_2.JavaCritter;
// CS 145 Homework (Critters)
// Version 3.0
// Authors: Stuart Reges and Marty Stepp
//          modified by Michael A. Wood
//
// CritterMain provides the main method for a simple simulation program.  Alter
// the number of each critter added to the simulation if you want to experiment
// with different scenarios.  You can also alter the width and height passed to
// the CritterFrame constructor.

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame(80, 50);

        // uncomment each of these lines as you complete these classes
        // frame.add(30, Bear.class);
        // frame.add(30, Lion.class);
        // frame.add(30, Giant.class);
		// frame.add(30, Titan.class);
        
        frame.add(30, FlyTrap.class);
        frame.add(30, Food.class);

        frame.start();
    }
}
