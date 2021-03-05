package model.parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParkingSpot {
    private String parkingSpotId;
    private boolean isFree;
    private ParkingSpotType parkingSpotType;
    private String assignedVehicleId;


    public ParkingSpot(String parkingSpotId, ParkingSpotType parkingSpotType) {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
    }

    public void assignedVehicleSpot(String vehicleId) {
        this.assignedVehicleId = assignedVehicleId;
    }

    public void freeSpot() {
        this.isFree = true;
        this.assignedVehicleId = null;
    }
}
