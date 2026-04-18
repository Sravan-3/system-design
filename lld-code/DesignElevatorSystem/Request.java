package DesignElevatorSystem;

class Request {

    private final int sourceFloor;
    private final int targetFloor;
    private final Direction direction;

    public Request(int sourceFloor, int targetFloor, Direction direction) {
        this.sourceFloor = sourceFloor;
        this.targetFloor = targetFloor;
        this.direction = direction;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public Direction getDirection() {
        return direction;
    }
}