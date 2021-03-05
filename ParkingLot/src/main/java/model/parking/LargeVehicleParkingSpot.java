package model.parking;

import static model.parking.ParkingSpotType.LARGE;

public  class LargeVehicleParkingSpot extends ParkingSpot {
    public LargeVehicleParkingSpot(String id) {
        super(id, LARGE);
    }
}
