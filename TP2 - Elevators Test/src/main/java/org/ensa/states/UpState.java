package org.ensa.states;

import org.ensa.models.Elevator;
import org.ensa.models.ElevatorState;

public class UpState implements ElevatorState {

    @Override
    public void moveUp(Elevator elevator) {
        // Move up if there are no stop floors or current floor is not in stop list
        if (!elevator.getStopFloors().contains(elevator.getCurrentFloor())) {
            elevator.incrementFloor();
        }
    }

    @Override
    public void moveDown(Elevator elevator) {
        elevator.setState(new DownState());
        elevator.moveDown();
    }

    @Override
    public int calculateDistance(Elevator elevator, int targetFloor) {
        if (targetFloor >= elevator.getCurrentFloor()) {
            return targetFloor - elevator.getCurrentFloor();
        }
        // A moving-up elevator cannot serve lower floors until it reaches the top
        return Integer.MAX_VALUE;
    }

    @Override
    public void stop(Elevator elevator) {
        elevator.setState(new RestingState());
    }



}
