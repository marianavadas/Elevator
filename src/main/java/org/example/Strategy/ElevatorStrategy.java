package org.example.Strategy;

import org.example.Floor;

import java.util.List;

abstract public class ElevatorStrategy {
    abstract public Floor getNextFloor(List<Floor> remainingFloors, Floor currentFloor);
}
