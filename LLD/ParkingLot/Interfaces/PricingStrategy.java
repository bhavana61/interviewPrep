package LLD.ParkingLot.Interfaces;

import LLD.ParkingLot.Models.Ticket;

public interface PricingStrategy {
    public double calculatePrice(Ticket t);
}
