package LLD.ParkingLot;

import LLD.ParkingLot.Enums.ParkingSpotType;
import LLD.ParkingLot.Interfaces.Observer;
import LLD.ParkingLot.Interfaces.Subject;
import LLD.ParkingLot.Models.ParkingFloor;
import LLD.ParkingLot.Models.Slots.ParkingSpot;
import LLD.ParkingLot.Models.Vehicle;
import LLD.ParkingLot.Services.ActionCompletionSubject;
import LLD.ParkingLot.Services.EmailObserver;
import LLD.ParkingLot.Services.SmsObserver;
import LLD.ParkingLot.Services.WhatsAppObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Helloxyz, World!");
        ParkingLot parkingLot=ParkingLot.getInstance();
        ParkingSpot parkingSpotBike=new ParkingSpot();
        parkingSpotBike.setNumber(1);
        parkingSpotBike.setParkingSpotType(ParkingSpotType.BIKE);
        List<ParkingSpot> parkingSpotBikeList=new ArrayList<>();
        parkingSpotBikeList.add(parkingSpotBike);
        ParkingSpot parkingSpotCar=new ParkingSpot();
        parkingSpotCar.setNumber(2);
        parkingSpotCar.setParkingSpotType(ParkingSpotType.CAR);
        List<ParkingSpot> parkingSpotCarList=new ArrayList<>();
        parkingSpotCarList.add(parkingSpotCar);

        Observer emailObserver=new EmailObserver();
        Observer smsObserver=new SmsObserver();
        Observer whatsAppObserver=new WhatsAppObserver();

        Subject s=new ActionCompletionSubject();
        s.registerObserver("email",emailObserver);
        s.registerObserver("sms",smsObserver);
        s.registerObserver("whatsApp",whatsAppObserver);

        parkingLot.setSubject(s);

        ParkingFloor parkingFloor=new ParkingFloor();
        parkingFloor.setNumber("1");
        HashMap<ParkingSpotType, List<ParkingSpot>> hashMap=new HashMap<>();
        hashMap.put(ParkingSpotType.BIKE,parkingSpotBikeList);
        hashMap.put(ParkingSpotType.CAR,parkingSpotCarList);
        parkingFloor.spots=hashMap;
        parkingLot.parkingFloorHashMap.put("1",parkingFloor);

        Vehicle vehicle=new Vehicle();
        vehicle.setVehicleNo("1234");
        vehicle.setParkingSpotType(ParkingSpotType.BIKE);
        parkingLot.park(vehicle,"1");

        parkingLot.unPark(vehicle,"upi");

    }
}
