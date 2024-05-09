package LLD.ParkingLot.Services;

import LLD.ParkingLot.Interfaces.Observer;
import LLD.ParkingLot.Interfaces.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionCompletionSubject implements Subject {

    Map<String,Observer> observerMap=new HashMap<>();
    @Override
    public void registerObserver(String notificationType,Observer observer) {
            observerMap.put(notificationType,observer);
    }

    @Override
    public void unregisterObserver(String notificationType) {
             observerMap.remove(notificationType);
    }

    @Override
    public void notifyObservers(String notificationType,String message) {
           if(notificationType.equalsIgnoreCase("all")){
               for(Map.Entry<String,Observer> entry:observerMap.entrySet()){
                   entry.getValue().update(message);
               }
           }
           else{
               observerMap.get(message).update(message);
           }
    }
}
