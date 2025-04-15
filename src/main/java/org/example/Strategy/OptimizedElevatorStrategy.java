package org.example.Strategy;

import org.example.Floor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptimizedElevatorStrategy extends ElevatorStrategy {
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
                Optional<Floor> closestFloors = possibleFloors.stream().min(Comparator.comparingInt(floor -> floor.getFloorNumber() - currentFloor.getFloorNumber()));
                if (closestFloors.isPresent()) {
                    return closestFloors.get();
                }
                else {
                    return possibleFloors.get(0);
                }
            }
            else {
                return remainingFloors.get(0);
            }
        }
        else {
            Optional<Floor> closestFloors = remainingFloors.stream().min(Comparator.comparingInt(floor -> floor.getFloorNumber() - currentFloor.getFloorNumber()));
            if (closestFloors.isPresent()) {
                return closestFloors.get();
            }
            else {
                return remainingFloors.get(0);
            }
        }
    }
}

