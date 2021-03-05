package model.vehicle;

import lombok.Getter;
import lombok.Setter;
import model.parking.ParkingTicket;

@Getter
@Setter
public abstract class Vehicle {
    private String licenseNumber;
    private final VehicleType vehicleType;
    private ParkingTicket parkingTicket;

    public Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = type;
    }
}
