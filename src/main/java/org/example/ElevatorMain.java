package org.example;

import org.example.Strategy.OptimizedElevatorStrategy;
import org.example.Strategy.RegularElevatorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevatorMain {
    public static void main(String[] args) {
        System.out.print("Please enter a series of floor numbers separated by commas: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        List<Integer> floorNumbers = new ArrayList<>();
        for (String part : parts) {
            floorNumbers.add(Integer.parseInt(part));
        }

        System.out.print("Enter 0 if you want all floors to have single buttons, otherwise enter 1.");
        scanner = new Scanner(System.in);
        int buttonChoice = scanner.nextInt();
        if (buttonChoice == 1) {
            System.out.print("Enter up/down for every floor number you want to have up or down, enter none for a single button floor. Separate by commas.");
            scanner = new Scanner(System.in);
            String inputButtons = scanner.nextLine();
            String[] buttons = inputButtons.split(",");
            List<String> directions = new ArrayList<>();
            List<String> buttonList = new ArrayList<>();
            for (String button : buttons) {
                directions.add(button);
                if (button.equals("none")) {
                    buttonList.add("single");
                }
                else {
                    buttonList.add("multiple");
                }
            }
            System.out.print("Enter 0 for an optimized elevator. Enter 1 for a regular elevator.");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 0) {
                OptimizedElevatorStrategy optimizedElevatorStrategy = new OptimizedElevatorStrategy();
                FloorFactory floorFactory = new FloorFactory();
                List<Floor> floors = floorFactory.createAllFloors(floorNumbers, buttonList, directions);
                Building building = new Building(floors, optimizedElevatorStrategy);
                building.runElevator();
                System.out.println("Time taken: " + building.getElevator().getTimeTaken());
                System.out.println("Floors visited in order: " + building.getElevator().getFloorsVisited());
            }
            else {
                RegularElevatorStrategy regularElevator = new RegularElevatorStrategy();
                FloorFactory floorFactory = new FloorFactory();
                List<Floor> floors = floorFactory.createAllFloors(floorNumbers, buttonList, directions);
                Building building = new Building(floors, regularElevator);
                building.runElevator();
                System.out.println("Time taken: " + building.getElevator().getTimeTaken());
                System.out.println("Floors visited in order: " + building.getElevator().getFloorsVisited());
            }
        }
        else {
            System.out.print("Enter 0 for an optimized elevator. Enter 1 for a regular elevator.");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 0) {
                OptimizedElevatorStrategy optimizedElevatorStrategy = new OptimizedElevatorStrategy();
                FloorFactory floorFactory = new FloorFactory();
                List<Floor> floors = floorFactory.createAllFloors(floorNumbers);
                Building building = new Building(floors, optimizedElevatorStrategy);
                building.runElevator();
                System.out.println("Time taken: " + building.getElevator().getTimeTaken());
                System.out.println("Floors visited in order: " + building.getElevator().getFloorsVisited());
            }
            else {
                RegularElevatorStrategy regularElevator = new RegularElevatorStrategy();
                FloorFactory floorFactory = new FloorFactory();
                List<Floor> floors = floorFactory.createAllFloors(floorNumbers);
                Building building = new Building(floors, regularElevator);
                building.runElevator();
                System.out.println("Time taken: " + building.getElevator().getTimeTaken());
                System.out.println("Floors visited in order: " + building.getElevator().getFloorsVisited());
            }
        }
    }
}
