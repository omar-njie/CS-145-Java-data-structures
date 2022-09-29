package com.omar.data_structures.assignments.assignment_2.JavaCritter;
// The CritterInfo interface defines a set of methods for querying the
// state of a critter simulation.  You should not alter this file.  See
// the documentation in the Critter class for a more detailed explanation.

public interface CritterInfo {
    Critter.Neighbor getFront();
    Critter.Neighbor getBack();
    Critter.Neighbor getLeft();
    Critter.Neighbor getRight();
    Critter.Direction getDirection();
    Critter.Direction getFrontDirection();
    Critter.Direction getBackDirection();
    Critter.Direction getLeftDirection();
    Critter.Direction getRightDirection();
}
