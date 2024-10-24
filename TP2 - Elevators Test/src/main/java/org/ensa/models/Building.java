package org.ensa.models;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Building {

    private List<Elevator> elevators = new ArrayList<>();
    private int numberOfFloors;

    public Building(int numberOfFloors, String... elevatorInfo) {
        this.numberOfFloors = numberOfFloors;
        for (String info : elevatorInfo) {
            String[] parts = info.split(":");
            String id = parts[0];
            int currentFloor = Integer.parseInt(parts[1]);
            // Elevators are initialized with a resting state by default
            elevators.add(new Elevator(id, currentFloor));
        }
    }

    /** First available elevator to the top floor **/
    public String requestElevator() {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        // Delegate the distance calculation to each elevator's state
        for (Elevator elevator : elevators) {
            int currentDistance = elevator.calculateDistance(numberOfFloors);
            if (currentDistance < minDistance) {
                closestElevator = elevator;
                minDistance = currentDistance;
            }
        }

        return closestElevator != null ? closestElevator.getId() : null;
    }

    /** Move the elevator UP or DOWN **/
    public void move(String elevatorId, String direction) {
        for (Elevator elevator : elevators) {
            if (elevator.getId().equals(elevatorId)) {
                if (direction.equalsIgnoreCase("UP")) {
                    elevator.moveUp();
                } else if (direction.equalsIgnoreCase("DOWN")) {
                    elevator.moveDown();
                }
            }
        }
    }
}
