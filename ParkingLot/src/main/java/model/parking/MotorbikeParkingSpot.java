package model.parking;

import lombok.Getter;
import lombok.Setter;

public class MotorbikeParkingSpot extends ParkingSpot {

    public MotorbikeParkingSpot(String id) {
        super(id, ParkingSpotType.MOTORBIKE);
    }
}
