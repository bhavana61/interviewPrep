package src.Interfaces;

import src.Entities.Ride;

public interface CabInterface {
    public double calculateFare(Ride ride, int tip);
}
