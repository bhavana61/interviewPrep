package LLD.ParkingLot.Factory;

import LLD.ParkingLot.Interfaces.PaymentInterface;
import LLD.ParkingLot.Services.CardPayment;
import LLD.ParkingLot.Services.UpiPayment;

public class PaymentFactory {
    PaymentInterface paymentInterface;
    public boolean processPayment(String paymentMode,String PaymentDetails,Double amount) {
        switch (paymentMode.toLowerCase()) {
            case "upi":
                paymentInterface = new UpiPayment();
                break;
            case "card":
                paymentInterface = new CardPayment();
                break;
            default:
                System.out.println("invalid payment type :" + paymentMode);
        }
        paymentInterface.pay(PaymentDetails,amount);
        return true;
    }
}
