package org.ensa.models;

import lombok.Getter;
import lombok.Setter;
import org.ensa.states.RestingState;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Elevator {
    private String id;
    private int currentFloor;
    private ElevatorState state;
    private Set<Integer> stopFloors = new HashSet<>();

    public Elevator(String id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.state = new RestingState();
    }

    public void moveUp() {
        state.moveUp(this);
    }

    public void moveDown() {
        state.moveDown(this);
    }

    public void stopAt(int floor) {
        stopFloors.add(floor);
    }

    public void removeStop(int floor) {
        stopFloors.remove(floor);
    }

    public void incrementFloor() {
        currentFloor++;
        if (stopFloors.contains(currentFloor)) {
            stopFloors.remove(currentFloor); // Remove stop if reached
            state = new RestingState(); // Change state to Resting
        }
    }

    public void decrementFloor() {
        currentFloor--;
        if (stopFloors.contains(currentFloor)) {
            stopFloors.remove(currentFloor); // Remove stop if reached
            state = new RestingState(); // Change state to Resting
        }
    }

    public int calculateDistance(int targetFloor) {
        return state.calculateDistance(this, targetFloor);
    }
}
