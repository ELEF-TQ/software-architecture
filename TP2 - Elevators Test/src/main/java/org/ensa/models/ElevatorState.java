package org.ensa.models;

public interface ElevatorState {
    void moveUp(Elevator elevator);
    void moveDown(Elevator elevator);
//    void stop(Elevator elevator);

    int calculateDistance(Elevator elevator, int targetFloor);
}

