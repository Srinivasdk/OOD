package model.parking;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class HourlyCost {
    private Map<ParkingSpotType, Double> hourlyCost = new HashMap<>();

    public  HourlyCost () {
        hourlyCost.put(ParkingSpotType.CAR, 20.0);
        hourlyCost.put(ParkingSpotType.LARGE, 30.0);
        hourlyCost.put(ParkingSpotType.ELECTRIC, 25.0);
        hourlyCost.put(ParkingSpotType.MOTORBIKE, 10.0);
        hourlyCost.put(ParkingSpotType.ABLED, 25.0);
    }

    public Double getcost(ParkingSpotType parkingSpotType) {
        return hourlyCost.get(parkingSpotType);
    }

}
