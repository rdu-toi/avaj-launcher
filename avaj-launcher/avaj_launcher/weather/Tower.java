package avaj_launcher.weather;

import java.util.ArrayList;
import java.util.List;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public class Tower{
    private static List<Flyable> observers = new ArrayList<Flyable>();
    private static List<Flyable> unregistered = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        unregistered.add(flyable);
    }

    protected void conditionsChanged(){
        for (Flyable flyable: observers){
            flyable.updateConditions();
        }
        observers.removeAll(unregistered);
    }

}