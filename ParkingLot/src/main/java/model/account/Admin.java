package model.account;

import model.parking.EntrancePanel;
import model.parking.ExitPanel;
import model.parking.ParkingFloor;
import model.parking.ParkingLot;
import model.parking.ParkingSpot;

import java.util.Optional;

public class Admin extends Account{

    public void addParkingFloor(ParkingFloor parkingfloor) {
        Optional<ParkingFloor> floor =
                ParkingLot.INSTANCE.getParkingFloors().stream()
                .filter(pF -> pF.getFloorId().equalsIgnoreCase(parkingfloor.getFloorId()))
                .findFirst();
        if(floor.isPresent())
            return;

        ParkingLot.INSTANCE.getParkingFloors().add(parkingfloor);
    }

    public void addParkingSpot(String parkingFloorId, ParkingSpot parkingSpot) {
        Optional<ParkingFloor> floor =
                ParkingLot.INSTANCE.getParkingFloors().stream()
                .filter(pF -> pF.getFloorId().equalsIgnoreCase(parkingFloorId))
                .findFirst();
        if(!floor.isPresent())
            throw InvlaidParkingFloorException("Invalid floor");
        Optional<ParkingSpot> spot = floor.get().getParkingSpots().get(parkingSpot.getParkingSpotType())
                .stream().filter(pS -> pS.getParkingSpotId().equalsIgnoreCase(parkingSpot.getParkingSpotId()))
                .findFirst();
        if(spot.isPresent())
            return;
        floor.get().getParkingSpots().get(parkingSpot.getParkingSpotType()).add(parkingSpot);
    }

    public void addEntrancePanel(EntrancePanel entrancePanel) {
        Optional<EntrancePanel> panel =
                ParkingLot.INSTANCE.getEntrancePanels().stream()
                        .filter(eP -> eP.getId().equalsIgnoreCase(entrancePanel.getId())).findFirst();
        if (panel.isPresent())
            return;
        ParkingLot.INSTANCE.getEntrancePanels().add(entrancePanel);
    }

    public void addExitPanel(ExitPanel exitPanel) {
        Optional<ExitPanel> panel =
                ParkingLot.INSTANCE.getExitPanels().stream()
                        .filter(eP -> eP.getId.equalsIgnoreCase(exitPanel.getId())).findFirst();
        if (panel.isPresent())
            return;
        ParkingLot.INSTANCE.getExitPanels().add(exitPanel);
    }
}
