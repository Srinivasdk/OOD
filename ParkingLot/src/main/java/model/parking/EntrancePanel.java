package model.parking;


import lombok.Getter;
import model.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class EntrancePanel {
    private String id;

    public EntrancePanel(String id) {
        this.id = id;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        if(!ParkingLot.INSTANCE.canPark(vehicle.getVehicleType())) {
            return null;
        }
        ParkingSpot parkingSpot = ParkingLot.INSTANCE.getParkingSpot(vehicle.getVehicleType());

//        if(parkingSpot == null)
//            return null;

        return ParkingTicket.builder()
                .allocatedSpotId(parkingSpot.getParkingSpotId())
                .issuedAt(LocalDateTime.now())
                .licencePlateNumber(vehicle.getLicenseNumber())
                .ticketNumber(UUID.randomUUID().toString())
                .ticketStatus(TicketStatus.ACTIVE)
                .build();
    }

}
