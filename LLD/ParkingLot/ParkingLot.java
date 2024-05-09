package LLD.ParkingLot;

import LLD.ParkingLot.Factory.PaymentFactory;
import LLD.ParkingLot.Interfaces.PaymentInterface;
import LLD.ParkingLot.Interfaces.PricingStrategy;
import LLD.ParkingLot.Interfaces.Subject;
import LLD.ParkingLot.Models.ParkingFloor;
import LLD.ParkingLot.Models.Slots.ParkingSpot;
import LLD.ParkingLot.Models.Ticket;
import LLD.ParkingLot.Models.Vehicle;
import LLD.ParkingLot.Services.ActionCompletionSubject;
import LLD.ParkingLot.Services.CustomPricingStartegy;
import LLD.ParkingLot.Services.DefaultPricingStrategy;
import LLD.ParkingLot.Services.UpiPayment;
import LLD.ParkingLot.Utils.AutoIncrement;

import java.util.*;

public class ParkingLot {
    AutoIncrement autoIncrement = new AutoIncrement();

    static HashMap<String,ParkingFloor> parkingFloorHashMap;

    static HashMap<String,Ticket> activeTickets;

    static HashMap<String,Ticket> archivedTickets;

    static PricingStrategy pricingStrategy;

    static PaymentFactory paymentFactory=new PaymentFactory();

    Subject subject=new ActionCompletionSubject();

    private static ParkingLot instance;

    private ParkingLot() {}

    public static ParkingLot getInstance(){
        if(instance==null){
           synchronized(ParkingLot.class){
           if(instance==null){
                parkingFloorHashMap = new HashMap<>();
                activeTickets = new HashMap<>();
                archivedTickets = new HashMap<>();
                pricingStrategy = new DefaultPricingStrategy();
                instance = new ParkingLot();
            }
           }
        }
        return instance;
    }


    public void park(Vehicle v,String floor){
        List<ParkingSpot> parkingSpots=parkingFloorHashMap.get(floor).getSpots().get(v.getParkingSpotType());
        for (int i=0;i<parkingSpots.size();i++) {
                  if(parkingSpots.get(i).getVehicle()==null){
                      parkingSpots.get(i).setVehicle(v);
                  }
                  parkingSpots.set(i,parkingSpots.get(i));
                  parkingFloorHashMap.get(floor).updateSpotsofType(v.getParkingSpotType(),parkingSpots);
                  //generate ticket
            Ticket t=new Ticket();
            t.setTicketNo(autoIncrement.getNext());
            t.setFloorNo(floor);
            Date date=new Date();
            t.setStartTime(date);
            t.setSpotNo(i);
            subject.notifyObservers("all","t.toString()");
            activeTickets.put(v.getVehicleNo(), t);
        }
    }

    public void unPark(Vehicle v,String paymentMode){
       Ticket t=activeTickets.get(v.getVehicleNo());

       pricingStrategy= new CustomPricingStartegy();
       Double amount=  pricingStrategy.calculatePrice(t);

       activeTickets.remove(v.getVehicleNo());
       archivedTickets.put(v.getVehicleNo(),t);
       ParkingSpot parkingSpot=parkingFloorHashMap.get(t.getFloorNo()).spots.get(v.getParkingSpotType()).get(t.getSpotNo());
       parkingSpot.setVehicle(null);
       parkingFloorHashMap.get(t.getFloorNo()).spots.get(v.getParkingSpotType()).set(t.getSpotNo(),parkingSpot);

       //
       paymentFactory.processPayment("UPI","@ybl",amount);
       subject.notifyObservers("all",amount+" payment completed");
    }

    public AutoIncrement getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(AutoIncrement autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public static HashMap<String, ParkingFloor> getParkingFloorHashMap() {
        return parkingFloorHashMap;
    }

    public static void setParkingFloorHashMap(HashMap<String, ParkingFloor> parkingFloorHashMap) {
        ParkingLot.parkingFloorHashMap = parkingFloorHashMap;
    }

    public static HashMap<String, Ticket> getActiveTickets() {
        return activeTickets;
    }

    public static void setActiveTickets(HashMap<String, Ticket> activeTickets) {
        ParkingLot.activeTickets = activeTickets;
    }

    public static HashMap<String, Ticket> getArchivedTickets() {
        return archivedTickets;
    }

    public static void setArchivedTickets(HashMap<String, Ticket> archivedTickets) {
        ParkingLot.archivedTickets = archivedTickets;
    }

    public static PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public static void setPricingStrategy(PricingStrategy pricingStrategy) {
        ParkingLot.pricingStrategy = pricingStrategy;
    }

    public static PaymentFactory getPaymentFactory() {
        return paymentFactory;
    }

    public static void setPaymentFactory(PaymentFactory paymentFactory) {
        ParkingLot.paymentFactory = paymentFactory;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public static void setInstance(ParkingLot instance) {
        ParkingLot.instance = instance;
    }
}
