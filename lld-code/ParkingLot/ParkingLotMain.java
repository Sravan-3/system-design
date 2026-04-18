package ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLotMain {

    private final List<ParkingFloor> floors;
    private final Map<String, ParkingTicket> activeTickets;
    private final ParkingFeeStrategy feeStrategy;

    public ParkingLotMain(List<ParkingFloor> floors, ParkingFeeStrategy feeStrategy) {
        this.floors = floors;
        this.feeStrategy = feeStrategy;
        this.activeTickets = new HashMap<>();
    }

    public String parkVehicle(Vehicle vehicle) {

        for (ParkingFloor floor : floors) {
            Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);

            if (spot.isPresent()) {
                ParkingSpot parkingSpot = spot.get();
                parkingSpot.parkVehicle(vehicle);

                ParkingTicket ticket = new ParkingTicket(vehicle, parkingSpot);
                activeTickets.put(ticket.getTicketId(), ticket);

                return ticket.getTicketId();
            }
        }

        throw new RuntimeException("Parking Full");
    }

    public double exitVehicle(String ticketId) {

        ParkingTicket ticket = activeTickets.get(ticketId);

        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket");
        }

        ticket.getSpot().removeVehicle();

        double fee = feeStrategy.calculateFee(ticket);

        activeTickets.remove(ticketId);

        return fee;
    }
    
}
