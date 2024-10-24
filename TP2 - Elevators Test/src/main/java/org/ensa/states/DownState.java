package org.ensa.states;

import org.ensa.models.Elevator;
import org.ensa.models.ElevatorState;

public class DownState implements ElevatorState {

    @Override
    public void moveUp(Elevator elevator) {
        elevator.setState(new UpState());
        elevator.moveUp();
    }

    @Override
    public void moveDown(Elevator elevator) {
        elevator.decrementFloor();
    }

    @Override
    public int calculateDistance(Elevator elevator, int targetFloor) {
        if (targetFloor <= elevator.getCurrentFloor()) {
            return elevator.getCurrentFloor() - targetFloor;
        }
        // A moving-down elevator cannot serve higher floors until it reaches the bottom
        return Integer.MAX_VALUE;
    }

//    @Override
//    public void stop(Elevator elevator) {
//        elevator.setState(new RestingState());
//    }



}
