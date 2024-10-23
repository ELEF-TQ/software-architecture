package org.ensa.models;

import lombok.Getter;
import lombok.Setter;
import org.ensa.states.DownState;
import org.ensa.states.RestingState;
import org.ensa.states.UpState;

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

    /** First available elevator to top floor **/
    public String requestElevator() {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int currentDistance = Math.abs(elevator.getCurrentFloor() - numberOfFloors);
            if (elevator.getState() instanceof UpState || elevator.getState() instanceof RestingState) {
                if (currentDistance < minDistance) {
                    closestElevator = elevator;
                    minDistance = currentDistance;
                }
            }
        }
        return closestElevator != null ? closestElevator.getId() : null;
    }

    /** move the elevator UP or DOWN **/
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
