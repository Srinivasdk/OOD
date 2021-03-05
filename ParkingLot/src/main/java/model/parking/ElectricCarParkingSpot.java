package model.parking;

import static model.parking.ParkingSpotType.ELECTRIC;

public class ElectricCarParkingSpot extends ParkingSpot {
    public ElectricCarParkingSpot(String id) {
        super(id, ELECTRIC);
    }
}
