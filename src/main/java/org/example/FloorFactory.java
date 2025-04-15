package org.example;

import java.util.ArrayList;
import java.util.List;

// Used to make it easier to make floors.
// Also helps memory with only using "new" in here, not elsewhere
public class FloorFactory {

    public Floor createSingleFloor (int floorNumber) {
        return new SingleFloor(floorNumber);
    }

    public Floor createUpDownFloor (int floorNumber, String direction) {
        return new UpDownFloor(floorNumber, direction);
    }

    public List<Floor> createAllFloorsWithDifferentButtonTypes (List<Integer> floors, List<String> buttonTypes, List<String> directions) {
        List<Floor> allFloors = new ArrayList<>();
        for (int i = 0; i < floors.size(); i++) {
            if (buttonTypes.get(i).equals("single")) {
                allFloors.add(createSingleFloor(floors.get(i)));
            }
            else {
                allFloors.add(createUpDownFloor(floors.get(i) + 1, directions.get(i)));
            }

        }
        return allFloors;
    }

    public List<Floor> createAllFloors(List<Integer> floors, List<String> buttonTypes, List<String> directions) {
        List<Floor> allFloors = new ArrayList<>();
        for (int i = 0; i < floors.size(); i++) {
            if (buttonTypes.get(i).equals("single")) {
                allFloors.add(createSingleFloor(floors.get(i)));
            }
            else {
                allFloors.add(createUpDownFloor(floors.get(i), directions.get(i)));
            }
        }
        return allFloors;
    }

    public List<Floor> createAllFloors(List<Integer> floors) {
        List<Floor> allFloors = new ArrayList<>();
        for (int i = 0; i < floors.size(); i++) {
            allFloors.add(createSingleFloor(floors.get(i)));
        }
        return allFloors;
    }

    public List<Floor> createAllFloors(List<Integer> floors, List<String> directions) {
        List<Floor> allFloors = new ArrayList<>();
        for (int i = 0; i < floors.size(); i++) {
            allFloors.add(createUpDownFloor(floors.get(i), directions.get(i)));
        }
        return allFloors;
    }
}
