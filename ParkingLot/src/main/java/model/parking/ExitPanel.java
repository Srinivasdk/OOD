package model.parking;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitPanel {
    private String id;

    public ParkingTicket scanAndVacate(ParkingTicket parkingTicket) {
        ParkingSpot parkingSpot = ParkingLot.INSTANCE.vacateParkingSpot(parkingTicket.getAllocatedSpotId());
        parkingTicket.setCharges(calculateCost(parkingTicket, parkingSpot.getParkingSpotType()));
        return parkingTicket;
    }

    private double calculateCost(ParkingTicket parkingTicket, ParkingSpotType parkingSpotType) {
        Duration duration  = Duration.between(parkingTicket.getIssuedAt(), LocalDateTime.now());
        long hours = duration.toHours();
        if(hours == 0)
            hours = 1;

        return hours*new HourlyCost().getcost(parkingSpotType);
    }
}

