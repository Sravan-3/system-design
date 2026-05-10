package ParkingLot;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public class ParkingFloor {
    
    
    private final int floorNumber;
    private final List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spots){
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    public Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle){
        return spots.stream()
            .filter(spot -> spot.isAvailble() && spot.canFitVehicle(vehicle))
            .findFirst();
    }


}
