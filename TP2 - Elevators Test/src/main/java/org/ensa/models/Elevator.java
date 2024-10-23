package org.ensa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
        currentFloor++;
    }

    public void moveDown() {
        currentFloor--;
    }

    /** Delegate to the current state **/
    public void incrementFloor() {
        state.moveUp(this);
    }

    public void decrementFloor() {
        state.moveDown(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }



}
