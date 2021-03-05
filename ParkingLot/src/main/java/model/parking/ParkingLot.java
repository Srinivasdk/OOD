package model.parking;

import lombok.Getter;
import lombok.Setter;
import model.account.common.Address;
import model.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ParkingLot {
    private String parkingLotId;
    private Address address;

    private List<ParkingFloor> parkingFloors;
    private List<EntrancePanel> entrancePanels;
    private List<ExitPanel> exitPanels;

    public static ParkingLot INSTANCE = new ParkingLot();

    private ParkingLot() {
        this.parkingLotId = UUID.randomUUID().toString();
        parkingFloors = new ArrayList<>();
        entrancePanels = new ArrayList<>();
        exitPanels = new ArrayList<>();
    }


    public boolean isFull() {
        for(ParkingFloor parkingFloor : parkingFloors) {
            if(!parkingFloor.isFloorFull())
                return true;
        }
        return false;
    }

    public boolean canPark(VehicleType vehicleType) {
        for(ParkingFloor parkingFloor : parkingFloors) {
            if(parkingFloor.canPark(vehicleType)) {
                return true;
            }
        }
        return false;
    }

    public ParkingSpot getParkingSpot(VehicleType vehicleType) {
        for(ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloors()) {
            ParkingSpot parkingSpot = parkingFloor.getSpot(vehicleType);
            if(parkingSpot != null) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot vacateParkingSpot(String parkingSpotId) {
        for(ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloors()) {
            ParkingSpot parkingSpot = parkingFloor.vacateSpot(parkingSpotId);
            if(parkingSpot!=null)
                return parkingSpot;
        }
        return null;
    }
}
