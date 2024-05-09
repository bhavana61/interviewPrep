package LLD.ParkingLot.Services;

import LLD.ParkingLot.Interfaces.Observer;

public class SmsObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("SMS notification sent successfully");
    }
}