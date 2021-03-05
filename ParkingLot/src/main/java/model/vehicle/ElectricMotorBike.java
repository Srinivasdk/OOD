package model.vehicle;

public class ElectricMotorBike extends Vehicle {
    public ElectricMotorBike(String licenseNumber) {
        super(licenseNumber, VehicleType.EBIKE);
    }
}
