package org.example.Strategy;

import org.example.Floor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegularElevatorStrategy extends ElevatorStrategy {

    @Override
    public Floor getNextFloor(List<Floor> remainingFloors, Floor currentFloor) {
        if (currentFloor.isMultiple()) {
            List<Floor> possibleFloors = new ArrayList<>();
            if (currentFloor.getDirection().equals("up")) {
                possibleFloors = remainingFloors.stream().filter(floor -> floor.getFloorNumber() > currentFloor.getFloorNumber()).collect(Collectors.toList());
            }
            else {
                possibleFloors = remainingFloors.stream().filter(floor -> floor.getFloorNumber() < currentFloor.getFloorNumber()).collect(Collectors.toList());
            }
            if (!possibleFloors.isEmpty()) {
                return possibleFloors.get(0);
            }
            else {
                return remainingFloors.get(0);
            }
        }
        else {
            return remainingFloors.get(0);
        }
    }
}
