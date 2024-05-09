package LLD.ParkingLot.Models;

import LLD.ParkingLot.Enums.ParkingSpotType;
import LLD.ParkingLot.Models.Slots.ParkingSpot;

import java.util.HashMap;
import java.util.List;

public class ParkingFloor {
    public String number;
    //List<ParkingSpot> spots;
    public HashMap<ParkingSpotType, List<ParkingSpot>> spots;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public HashMap<ParkingSpotType, List<ParkingSpot>> getSpots() {
        return spots;
    }

    public void setSpots(HashMap<ParkingSpotType, List<ParkingSpot>> spots) {
        this.spots = spots;
    }

    public void updateSpotsofType(ParkingSpotType parkingSpotType,List<ParkingSpot> parkingSpots){
        spots.put(parkingSpotType,parkingSpots);
    }
}
