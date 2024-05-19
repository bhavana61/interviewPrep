package LLD.Media.net.src;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Media.net.src.Entities.Cab;
import LLD.Media.net.src.Entities.Person;
import LLD.Media.net.src.Enums.CabStatus;
import src.Entities.Location;
import src.Entities.Ride;
import src.Enums.CabType;
import src.Enums.UserType;
import src.Interfaces.CabInterface;
import src.Managers.BookingManager;

public class Ola {

    int personId;
    int cabId;
    int rideId;
    double thresholdDistance;
    Map<Integer, Person> personsMap;
    Map<Integer, Cab> cabsMap;
    Map<Integer, Ride> ridesMap;


    public Ola(double distanceToBookCab) {
        this.cabId = 1;
        this.personId = 1;
        this.rideId = 1;
        this.personsMap = new HashMap<>();
        this.cabsMap = new HashMap<>();
        this.ridesMap = new HashMap<>();
        this.thresholdDistance = distanceToBookCab;
    }

    public int registerRider(UserType userType) {
        Person person = new Person();
        person.personId = this.personId;
        person.userType = userType;
        this.personsMap.put(this.personId, person);
        return this.personId++;
    }

    public int registerCab(CabType cabType, int personId, double longitude, double lattitude) {
        Cab cab = new Cab();
        cab.cabId = this.cabId;
        cab.cabStatus = CabStatus.AVAILABLE;
        cab.cabType = cabType;
        cab.currentLocation = new Location(longitude, lattitude);
        cab.personId = personId;
        this.cabsMap.put(this.cabId, cab);
        return this.cabId++;
    }

    
    public int bookRide(int personId, double startLongitude, double startLattitude, double endLongitude, double endLattitude) throws Exception {
        Location starLocation = new Location(startLongitude, startLattitude);
        Location endLocation = new Location(endLongitude, endLattitude);
        List<Cab> cabsAvailableToBook = BookingManager.getNearestCabs(this.cabsMap, starLocation, this.thresholdDistance);
        if (cabsAvailableToBook.isEmpty()) {
            throw new Exception("No Cabs available to book");
        }
        Cab cab = BookingManager.bookRandom(cabsAvailableToBook);
        Ride ride = new Ride();
        ride.rideId = this.rideId;
        ride.starLocation = starLocation;
        ride.endLocation = endLocation;
        ride.cabId = cab.cabId;
        ride.userId = personId;
        this.ridesMap.put(this.rideId, ride);
        return this.rideId++;
    }

    public void updateCabLocation(int cabId, double longitude, double lattitude) {
        Cab cab = this.cabsMap.get(cabId);
        cab.currentLocation = new Location(longitude, lattitude);
    }

    public double completeRide(int rideId) {
        Ride ride = this.ridesMap.get(rideId);
        Cab cab = this.cabsMap.get(ride.cabId);
        CabInterface cabManager = Media.net.src.Factory.CabManagerFactory.getCabManager(cab.cabType);
        double price = cabManager.calculateFare(ride, 0);
        this.updateCabLocation(cab.cabId, ride.endLocation.longitude, ride.endLocation.lattitude);
        cab.cabStatus = CabStatus.AVAILABLE;
        return price;
    }
}
