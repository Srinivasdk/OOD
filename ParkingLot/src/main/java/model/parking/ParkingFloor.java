package model.parking;

import lombok.Getter;
import lombok.Setter;
import model.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static model.parking.ParkingSpotType.ABLED;
import static model.parking.ParkingSpotType.CAR;
import static model.parking.ParkingSpotType.ELECTRIC;
import static model.parking.ParkingSpotType.LARGE;
import static model.parking.ParkingSpotType.MOTORBIKE;

public class ParkingFloor {
    @Getter
    @Setter
    private String floorId;
    @Getter
    private Map<ParkingSpotType, List<ParkingSpot>> parkingSpots = new HashMap<>();
    private Map<String, ParkingSpot> usedParkingSpots = new HashMap<>();

    public ParkingFloor(String id) {
        this.floorId = id;
        parkingSpots.put(ABLED, new ArrayList<>()); // 50 size
        parkingSpots.put(CAR, new ArrayList<>());  // 50 size
        parkingSpots.put(LARGE, new ArrayList<>()); //50 size
        parkingSpots.put(MOTORBIKE, new ArrayList<>()); //50 size
        parkingSpots.put(ELECTRIC, new ArrayList<>()); //50 size

    }

    public boolean isFloorFull() {
        for(Map.Entry<ParkingSpotType, List<ParkingSpot>> entry : parkingSpots.entrySet()) {
            if(entry.getValue().size() != 50) {
                return false;
            }
        }
        return true;
    }

    public static ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType) {
        switch(vehicleType) {
            case CAR:
                return CAR;
            case ELECTRIC:
                return ELECTRIC;
            case MOTORBIKE:
                return MOTORBIKE;
            default:
                return LARGE;
        }
    }

    public boolean canPark(VehicleType vehicleType) {
        return canPark(getSpotTypeForVehicle(vehicleType));
    }


    public ParkingSpot getSpot(VehicleType vehicleType) {
        if(!canPark(vehicleType))
            return null;
        ParkingSpotType parkingSpotType = getSpotTypeForVehicle(vehicleType);

        //getting parking spot
        ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType).get(0);

        //removing parking spot
        parkingSpots.get(parkingSpotType).remove(0);

        // adding to used parking spots
        usedParkingSpots.put(parkingSpot.getParkingSpotId(), parkingSpot);

        return parkingSpot;

    }

    public ParkingSpot vacateSpot(String parkingSpotId) {
        ParkingSpot parkingSpot = usedParkingSpots.remove(parkingSpotId);
        if(parkingSpot != null) {
            parkingSpot.freeSpot();
            parkingSpots.get(parkingSpot.getParkingSpotType()).add(parkingSpot);
            return parkingSpot;
        }
        return  null;
    }

    public boolean canPark(ParkingSpotType parkingSpotType) {
        return parkingSpots.get(parkingSpotType).size()<50;
    }
}
