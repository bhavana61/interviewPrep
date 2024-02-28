package src.Entities;

import src.Enums.CabStatus;
import src.Enums.CabType;

public class Cab {
    public int cabId;
    public CabType cabType;
    public Location currentLocation;
    public int personId;
    public CabStatus cabStatus;
}
