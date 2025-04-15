package org.example;

import org.example.Strategy.ElevatorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    static final int DEFAULT_MOVING_TIME = 10;

    private Floor currentFloor;
    private int timeTaken;
    private List<Floor> floorsVisited;
    private ElevatorStrategy elevatorStrategy;


    public Elevator (Floor currentFloor, ElevatorStrategy elevatorStrategy) {
        this.currentFloor = currentFloor;
        this.timeTaken = 0;
        this.floorsVisited = new ArrayList<>();
        this.elevatorStrategy = elevatorStrategy;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public List<Floor> getFloorsVisited() {
        return floorsVisited;
    }

    // elevator strategy is either optimized or regular, based on what strategy what put into the
    // initialization of the building, the elevator will follow that strategy for all floors
    public Floor getNextFloor(List<Floor> remainingFloors, Floor currentFloor) {
        return elevatorStrategy.getNextFloor(remainingFloors, currentFloor);
    }

    public void moveFloors(Floor newFloor) {
        int floorDifference = Math.abs(currentFloor.getFloorNumber() - newFloor.getFloorNumber());
        currentFloor = newFloor;
        timeTaken += floorDifference * DEFAULT_MOVING_TIME;
        visitFloor(currentFloor);
    }

    // Used to keep track of the order of floors that have been visited
    public void visitFloor(Floor newFloor) {
        floorsVisited.add(newFloor);
    }
}
