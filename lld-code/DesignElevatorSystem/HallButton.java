package DesignElevatorSystem;

public class HallButton {

    private final int floorNumber;
    private final Direction direction;
    private final RequestManager requestManager;

    public HallButton(int floorNumber, Direction direction, RequestManager manager) {
        this.floorNumber = floorNumber;
        this.direction = direction;
        this.requestManager = manager;
    }

    public void press() {
        Request request = new Request(floorNumber, floorNumber, direction);
        requestManager.submitRequest(request);
    }
    
}
