package LLD.ParkingLot.Utils;

public class AutoIncrement {
    private int counter;

    public AutoIncrement() {
        this.counter = 0; // Initial value
    }

    public int getNext() {
        synchronized (AutoIncrement.class){
            return ++counter;
        }
    }
}

