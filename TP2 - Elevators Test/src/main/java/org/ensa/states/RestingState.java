package org.ensa.states;

import org.ensa.models.Elevator;
import org.ensa.models.ElevatorState;

public class RestingState implements ElevatorState {


    @Override
    public void moveUp(Elevator elevator) {
        System.out.println("Elevator is starting to move up.");
    }

    @Override
    public void moveDown(Elevator elevator) {
        System.out.println("Elevator is starting to move down.");
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Elevator at floor " + elevator.getCurrentFloor());
    }
}
