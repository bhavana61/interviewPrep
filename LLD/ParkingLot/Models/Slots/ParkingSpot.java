package LLD.ParkingLot.Models.Slots;

import LLD.ParkingLot.Enums.ParkingSpotType;
import LLD.ParkingLot.Enums.ParkingStatus;
import LLD.ParkingLot.Models.Vehicle;

public class ParkingSpot {
    Integer number;
    ParkingSpotType parkingSpotType;
    Vehicle vehicle;


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
