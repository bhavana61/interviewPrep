package src.Managers;

import src.Entities.Ride;
import src.Interfaces.CabInterface;

public class SedanManager implements CabInterface {
    @Override
    public double calculateFare(Ride ride, int tip) {
        double x = ride.starLocation.lattitude - ride.endLocation.lattitude;
        double y = ride.starLocation.longitude - ride.endLocation.longitude;
        return x*x + y*y + tip;
    }
}
