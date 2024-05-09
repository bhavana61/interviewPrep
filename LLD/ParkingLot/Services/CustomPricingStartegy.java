package LLD.ParkingLot.Services;

import LLD.ParkingLot.Interfaces.PricingStrategy;
import LLD.ParkingLot.Models.Ticket;

public class CustomPricingStartegy implements PricingStrategy {
    @Override
    public double calculatePrice(Ticket t) {
        return 0;
    }
}
