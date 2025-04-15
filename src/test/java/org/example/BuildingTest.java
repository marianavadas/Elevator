package org.example;

import org.example.Strategy.OptimizedElevatorStrategy;
import org.example.Strategy.RegularElevatorStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BuildingTest {

    @Test
    void testMovingFloorsSingleButton() {
        RegularElevatorStrategy regularElevator = new RegularElevatorStrategy();
        FloorFactory floorFactory = new FloorFactory();
        List<Integer> floorNumbers = Arrays.asList(9,8,3,2,4,1,7,6,10,5);
        List<Floor> floors = floorFactory.createAllFloors(floorNumbers);
        Building building = new Building(floors, regularElevator);
        building.runElevator();
        assert(building.getElevator().getTimeTaken() == 280);
        // Floors visited: 9,8,3,2,4,1,7,6,10,5
    }

    @Test
    void testMovingFloorsSingleButtonOptimized() {
        OptimizedElevatorStrategy optimizedElevator = new OptimizedElevatorStrategy();
        FloorFactory floorFactory = new FloorFactory();
        List<Integer> floorNumbers = Arrays.asList(9,8,3,2,4,1,7,6,10,5);
        List<Floor> floors = floorFactory.createAllFloors(floorNumbers);
        Building building = new Building(floors, optimizedElevator);
        building.runElevator();
        assert(building.getElevator().getTimeTaken() == 170);
        // Floors visited: 9,1,2,3,4,5,6,7,8,10
    }

    @Test
    void testMovingFloorsUpDownButton() {
        RegularElevatorStrategy regularElevator = new RegularElevatorStrategy();
        FloorFactory floorFactory = new FloorFactory();
        List<Integer> floorNumbers = Arrays.asList(9,8,3,2,4,1,7,6,10,5);
        List<String> directions = Arrays.asList("up","down","up","down","up","up","up","down","up","up","up");
        List<Floor> floors = floorFactory.createAllFloors(floorNumbers, directions);
        Building building = new Building(floors, regularElevator);
        building.runElevator();
        assert(building.getElevator().getTimeTaken() == 240);
        // Floors visited: 9,10,8,3,4,7,2,1,6,5
    }

    @Test
    void testMovingFloorsUpDownButtonOptimized() {
        OptimizedElevatorStrategy optimizedElevator = new OptimizedElevatorStrategy();
        FloorFactory floorFactory = new FloorFactory();
        List<Integer> floorNumbers = Arrays.asList(9,8,3,2,4,1,7,6,10,5);
        List<String> directions = Arrays.asList("up","down","up","down","up","up","up","down","up","up","up");
        List<Floor> floors = floorFactory.createAllFloors(floorNumbers, directions);
        Building building = new Building(floors, optimizedElevator);
        building.runElevator();
        assert(building.getElevator().getTimeTaken() == 160);
        // Floors visited: 9,10,8,1,2,3,4,5,6,7
    }

    @Test
    void testMovingFloorsMixButton() {
        RegularElevatorStrategy regularElevator = new RegularElevatorStrategy();
        FloorFactory floorFactory = new FloorFactory();
        List<Integer> floorNumbers = Arrays.asList(9,8,3,2,4,1,7,6,10,5);
        List<String> directions = Arrays.asList("none","down","up","down","up","up","up","down","up","up","none");
        List<String> buttonTypes = Arrays.asList("single", "multiple", "multiple", "multiple", "multiple", "multiple", "multiple", "multiple", "multiple", "single");
        List<Floor> floors = floorFactory.createAllFloors(floorNumbers, buttonTypes, directions);
        Building building = new Building(floors, regularElevator);
        building.runElevator();
        assert(building.getElevator().getTimeTaken() == 280);
        // Floors visited: 9,8,3,4,7,10,2,1,6,5
    }

    @Test
    void testMovingFloorsMixButtonOptimized() {
        OptimizedElevatorStrategy optimizedElevator = new OptimizedElevatorStrategy();
        FloorFactory floorFactory = new FloorFactory();
        List<Integer> floorNumbers = Arrays.asList(9,8,3,2,4,1,7,6,10,5);
        List<String> directions = Arrays.asList("none","down","up","down","up","up","up","down","up","up","none");
        List<String> buttonTypes = Arrays.asList("single", "multiple", "multiple", "multiple", "multiple", "multiple", "multiple", "multiple", "multiple", "single");
        List<Floor> floors = floorFactory.createAllFloors(floorNumbers, buttonTypes, directions);
        Building building = new Building(floors, optimizedElevator);
        building.runElevator();
        assert(building.getElevator().getTimeTaken() == 270);
        // Floors visited: 9,1,2,8,3,4,5,6,7,10
    }

    @Test
    void testExampleInDocument() {
        RegularElevatorStrategy regularElevator = new RegularElevatorStrategy();
        FloorFactory floorFactory = new FloorFactory();
        List<Integer> floorNumbers = Arrays.asList(12,2,9,1,32);
        List<Floor> floors = floorFactory.createAllFloors(floorNumbers);
        Building building = new Building(floors, regularElevator);
        building.runElevator();
        assert(building.getElevator().getTimeTaken() == 560);
        // Floors visited: 12,2,9,1,32
    }

    @Test
    void testExampleInDocumentOptimized() {
        OptimizedElevatorStrategy optimizedElevator = new OptimizedElevatorStrategy();
        FloorFactory floorFactory = new FloorFactory();
        List<Integer> floorNumbers = Arrays.asList(12,2,9,1,32);
        List<Floor> floors = floorFactory.createAllFloors(floorNumbers);
        Building building = new Building(floors, optimizedElevator);
        building.runElevator();
        assert(building.getElevator().getTimeTaken() == 420);
        // Floors visited: 12,1,2,9,32
    }
}
