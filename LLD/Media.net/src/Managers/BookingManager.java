package src.Managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import src.Entities.Cab;
import src.Entities.Location;
import src.Enums.CabStatus;

public class BookingManager {
    public static List<Cab> getNearestCabs(Map<Integer, Cab> cabsMap, Location location, double thresholdDistance) {
        List<Cab> cabs = new ArrayList<>();
        for (Cab cab : cabsMap.values()) {
            if (cab.cabStatus.equals(CabStatus.AVAILABLE) && distance(location, cab.currentLocation) <= thresholdDistance) {
                cabs.add(cab);
            }
        }
        return cabs;
    }

    public static Cab bookRandom(List<Cab> cabs) {
        Cab cab = cabs.get(0);
        cab.cabStatus = CabStatus.BOOKED;
        return cab;
    }

    private static double distance(Location l1, Location l2) {
        return Math.abs(l1.lattitude - l2.lattitude) + Math.abs(l1.longitude - l2.longitude);
    }
}
