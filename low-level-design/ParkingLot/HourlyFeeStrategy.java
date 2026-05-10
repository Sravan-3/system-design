package ParkingLot;

import java.time.Duration;
import java.time.LocalDateTime;

class HourlyFeeStrategy implements ParkingFeeStrategy {

    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(ParkingTicket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours() + 1;
        return hours * RATE_PER_HOUR;
    }
}
