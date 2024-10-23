package org.ensa.states;

import org.ensa.models.Elevator;
import org.ensa.models.ElevatorState;

public class UpState implements ElevatorState {

    @Override
    public void moveUp(Elevator elevator) {
        System.out.println("Elevator is moving up");
    }

    @Override
    public void moveDown(Elevator elevator) {
        System.out.println("Cannot move down while elevator is going up");
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Elevator is at floor " + elevator.getCurrentFloor());
    }
}
