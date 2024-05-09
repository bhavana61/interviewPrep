package LLD.ParkingLot.Models;

import java.util.Date;

public class Ticket {
    Integer ticketNo;
    //Vehicle vehicle;
    Date startTime;
    String floorNo;
    Integer spotNo;

    public Integer getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(Integer ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(Integer spotNo) {
        this.spotNo = spotNo;
    }
}
