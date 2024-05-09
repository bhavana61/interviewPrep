package LLD.ParkingLot.Services;

import LLD.ParkingLot.Interfaces.PaymentInterface;

public class CardPayment implements PaymentInterface {

    String cardDetails;
    @Override
    public Boolean pay(String paymentDetails, Double amount) {
        // deduct amount from account and transfer money
        cardDetails=paymentDetails;
        System.out.println("CardPayment completed");
        return true;
    }

    public String getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }
}
