package org.ensa.models;

import lombok.Getter;
import lombok.Setter;
import org.ensa.states.RestingState;

@Getter
@Setter
public class Elevator {
    private String id;
    private int currentFloor;
    private ElevatorState state;

    public Elevator(String id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.state = new RestingState();
    }

    public void moveUp() {
        state.moveUp(this);  // Delegate to state
    }

    public void moveDown() {
        state.moveDown(this);  // Delegate to state
    }

    public void decrementFloor() {
        // Safely decrement the floor without recursive calls
        if (currentFloor > 0) {
            currentFloor--;
        }
    }

    public void incrementFloor() {
        // Safely increment the floor
        currentFloor++;
    }

    public int calculateDistance(int targetFloor) {
        return state.calculateDistance(this, targetFloor);
    }
}
