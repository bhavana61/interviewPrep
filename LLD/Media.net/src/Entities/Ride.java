package src.Entities;

import java.util.Map;

public class Ride {
    // RideId, startLocation, endLocation, userId, cabId.
    public int rideId;
    public Location starLocation;
    public Location endLocation;
    public int userId;
    public int cabId;
    public Map<String, Double> prices;
}
