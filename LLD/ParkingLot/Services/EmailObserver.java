package LLD.ParkingLot.Services;

import LLD.ParkingLot.Interfaces.Observer;

public class EmailObserver implements Observer {
    public EmailObserver() {
    }

    @Override
    public void update(String message) {
        System.out.println("Email notification sent successfully");
    }
}
