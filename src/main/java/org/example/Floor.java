package org.example;

import java.util.List;

// Implements comparable to make it easier to compare floors with each other which is used
// when the elevator is at an UpDownFloor trying to find its next floor
public abstract class Floor implements Comparable<Floor>{
    protected int floorNumber;
    protected String direction;

    public Floor (int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public String getDirection() {
        return direction;
    }

    public Boolean isSingle() {
        return false;
    }
    public Boolean isMultiple() {
        return false;
    }

    // Makes it so I can print floors
    @Override
    public String toString() {
        return "Floor " + floorNumber;
    }

    @Override
    public int compareTo(Floor other) {
        return Integer.compare(this.floorNumber, other.floorNumber);
    }
}
