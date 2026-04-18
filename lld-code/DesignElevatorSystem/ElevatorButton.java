package DesignElevatorSystem;

class ElevatorButton {

    private final int destinationFloor;
    private final Elevator elevator;

    public ElevatorButton(int destinationFloor, Elevator elevator) {
        this.destinationFloor = destinationFloor;
        this.elevator = elevator;
    }

    public void press() {
        elevator.addStop(destinationFloor);
    }
}