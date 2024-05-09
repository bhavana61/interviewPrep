package LLD.Media.net.src.Entities;

//import src.Enums.CabStatus;
import LLD.Media.net.src.Enums.CabStatus;
import src.Enums.CabType;

public class Cab {
    public int cabId;
    public CabType cabType;
    public src.Entities.Location currentLocation;
    public int personId;
    public CabStatus cabStatus;
}
