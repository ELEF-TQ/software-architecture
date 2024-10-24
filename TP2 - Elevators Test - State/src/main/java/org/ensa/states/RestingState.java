package org.ensa.states;

import org.ensa.models.Elevator;
import org.ensa.models.ElevatorState;

public class RestingState implements ElevatorState {


    @Override
    public void moveUp(Elevator elevator) {
        elevator.setState(new UpState());
        elevator.moveUp();
    }

    @Override
    public void moveDown(Elevator elevator) {
        elevator.setState(new DownState());
        elevator.moveDown();
    }

    @Override
    public int calculateDistance(Elevator elevator, int targetFloor) {
        return Math.abs(elevator.getCurrentFloor() - targetFloor);
    }

    @Override
    public void stop(Elevator elevator) {
    }


}
