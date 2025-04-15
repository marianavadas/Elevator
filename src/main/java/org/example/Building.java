package org.example;

import org.example.Strategy.ElevatorStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Building {
    // Using logger to avoid System.out.print because it makes the program slightly vulnerable to attack
    public static final Logger logger = LoggerFactory.getLogger(Building.class);

    private Elevator elevator;
    private List<Floor> floorsToVisit;

    public Building(List<Floor> floorsToVisit, ElevatorStrategy elevatorStrategy) {
        // Elevator starts at the first floor on the list
        this.elevator = new Elevator(floorsToVisit.get(0), elevatorStrategy);
        elevator.visitFloor(floorsToVisit.get(0));
        this.floorsToVisit = floorsToVisit;
        this.floorsToVisit.remove(0);
    }

    public Elevator getElevator() {
        return elevator;
    }

    // Keeps visiting floors until all the floors have been visited. Uses the elevator strategy to find the nextFloor
    // the elevator is going to move to
    public void moveThroughFloors() {
        while (!floorsToVisit.isEmpty()) {
            Floor nextFloor = elevator.getNextFloor(floorsToVisit, elevator.getCurrentFloor());
            elevator.moveFloors(nextFloor);
            floorsToVisit.remove(nextFloor);
        }
    }

    // Runs the entire program
    public void runElevator() {
        moveThroughFloors();
        logger.info("Time take: " + elevator.getTimeTaken());
        logger.info("Order of floors visited: " + elevator.getFloorsVisited());
    }
}
