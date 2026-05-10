package DesignElevatorSystem;

import java.util.List;

class RequestManager {

    private final List<Elevator> elevators;

    public RequestManager(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public void submitRequest(Request request) {

        Elevator elevator = chooseElevator(request);

        if (elevator != null) {
            elevator.addStop(request.getSourceFloor());
        }
    }

    private Elevator chooseElevator(Request request) {

        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {

            if (elevator.getDirection() == request.getDirection()
                    || elevator.isIdle()) {

                int distance =
                        Math.abs(elevator.getCurrentFloor() - request.getSourceFloor());

                if (distance < minDistance) {
                    minDistance = distance;
                    best = elevator;
                }
            }
        }

        return best;
    }
}
