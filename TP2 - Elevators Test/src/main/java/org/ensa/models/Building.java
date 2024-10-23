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
            int currentFloor = Integer.parseInt(parts[1]); // Elevator current floor
            elevators.add(new Elevator(id, currentFloor));
        }
    }

    public String requestElevator() {
        int targetFloor = numberOfFloors; // last elevator
        return requestElevator(targetFloor);
    }

    public String requestElevator(int requestedFloor) {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int currentDistance = Math.abs(elevator.getCurrentFloor() - requestedFloor);
            if (currentDistance < minDistance) {
                closestElevator = elevator;
                minDistance = currentDistance;
            }
        }

        return closestElevator != null ? closestElevator.getId() : null;
    }
}
