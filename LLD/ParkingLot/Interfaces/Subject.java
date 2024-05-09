package LLD.ParkingLot.Interfaces;

public interface Subject {
  public void registerObserver(String notificationType,Observer observer);
  public void unregisterObserver(String notificationType);
  public void notifyObservers(String notificationType,String message);
}
