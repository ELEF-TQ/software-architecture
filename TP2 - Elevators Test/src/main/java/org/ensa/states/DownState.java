package org.ensa.states;

import org.ensa.models.Elevator;
import org.ensa.models.ElevatorState;

public class DownState implements ElevatorState {

    @Override
    public void moveUp(Elevator elevator) {
        System.out.println("cannot move up while elevator is going down");
    }

    @Override
    public void moveDown(Elevator elevator) {
        System.out.println("Elevator is moving down");
    }

    @Override
    public void stop(Elevator elevator) {
        System.out.println("Elevator is at floor " + elevator.getCurrentFloor());
    }
}
