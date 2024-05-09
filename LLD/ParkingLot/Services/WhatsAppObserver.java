package LLD.ParkingLot.Services;

import LLD.ParkingLot.Interfaces.Observer;

public class WhatsAppObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("whatsApp notification sent successfully");
    }
}