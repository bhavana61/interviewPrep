package LLD.ParkingLot.Services;

import LLD.ParkingLot.Interfaces.PaymentInterface;

public class UpiPayment implements PaymentInterface {
    String upiId;
    @Override
    public Boolean pay(String paymentDetails,Double amount) {
        // deduct amount from account and transfer money
        upiId=paymentDetails;
        System.out.println("upi payment completed");
        return true;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
}
