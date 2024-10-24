package org.ensa.states;

import org.ensa.models.Elevator;
import org.ensa.models.ElevatorState;

public class UpState implements ElevatorState {

    @Override
    public void moveUp(Elevator elevator) {
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
            // If the elevator has a stop before the target floor, treat it as unavailable
            for (int stopFloor : elevator.getStopFloors()) {
                if (stopFloor < targetFloor && stopFloor >= elevator.getCurrentFloor()) {
                    return Integer.MAX_VALUE;
                }
            }
            return targetFloor - elevator.getCurrentFloor();
        }
        return Integer.MAX_VALUE;
    }


    @Override
    public void stop(Elevator elevator) {
        elevator.setState(new RestingState());
    }



}
