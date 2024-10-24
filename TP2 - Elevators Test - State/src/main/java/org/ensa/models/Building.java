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
            elevators.add(new Elevator(id, currentFloor));
        }
    }

    public String requestElevator(int i) {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int currentDistance = elevator.calculateDistance(numberOfFloors);
            if (currentDistance < minDistance) {
                closestElevator = elevator;
                minDistance = currentDistance;
            }
        }

        return closestElevator != null ? closestElevator.getId() : null;
    }

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

    public void stopAt(String elevatorId, int floor) {
        for (Elevator elevator : elevators) {
            if (elevator.getId().equals(elevatorId)) {
                elevator.stopAt(floor);
            }
        }
    }
}
