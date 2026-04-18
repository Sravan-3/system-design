package DesignElevatorSystem;

import java.util.List;

import java.util.TreeSet;

@SuppressWarnings("unused")
class Elevator {

    private final int id;

    private int currentFloor;
    private Direction direction;
    private ElevatorState state;

    private final int capacity;
    private int currentLoad;

    private TreeSet<Integer> upStops;
    private TreeSet<Integer> downStops;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;

        upStops = new TreeSet<>();
        downStops = new TreeSet<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isIdle() {
        return state == ElevatorState.IDLE;
    }

    public void addStop(int floor) {

        if (floor > currentFloor) {
            upStops.add(floor);
        } else {
            downStops.add(floor);
        }
    }

    public void move() {

        if (direction == Direction.UP) {

            if (!upStops.isEmpty()) {
                currentFloor = upStops.pollFirst();
            } else {
                direction = Direction.DOWN;
            }

        } else if (direction == Direction.DOWN) {

            if (!downStops.isEmpty()) {
                currentFloor = downStops.pollLast();
            } else {
                direction = Direction.UP;
            }
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getId() {
        return id;
    }
}
