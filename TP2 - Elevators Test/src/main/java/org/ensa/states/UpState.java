package org.ensa.states;

import org.ensa.models.Elevator;
import org.ensa.models.ElevatorState;

public class UpState implements ElevatorState {

    @Override
    public void moveUp(Elevator elevator) {
        elevator.incrementFloor();
    }

    @Override
    public void moveDown(Elevator elevator) {
        elevator.setState(new DownState());
        elevator.moveDown();
    }

    @Override
    public void stop(Elevator elevator) {
        elevator.setState(new RestingState());
    }

}
