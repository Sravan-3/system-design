package ParkingLot;

import java.util.Optional;

public class ParkingSpot {

    private final String id;
    private final ParkingSpotType type;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpot(String id, ParkingSpotType type){
        this.id = id;
        this.type = type;
        this.occupied = false;
    }

    public boolean isAvailble(){
        return !occupied;   
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if (vehicle.getType() == VehicleType.BIKE)
            return true;

        if (vehicle.getType() == VehicleType.CAR)
            return type == ParkingSpotType.MEDIUM || type == ParkingSpotType.LARGE;

        return type == ParkingSpotType.LARGE;
    }

    public void parkVehicle(Vehicle vehicle) {

        if (occupied) {
            throw new IllegalStateException("Spot already occupied");
        }
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }

    public String getId() {
        return id;
    }

    public Optional<Vehicle> getVehicle(){
        return Optional.of(vehicle);
    }
    
}
