package avaj_launcher.flyable;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public class AircraftFactory{

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        if (height > 100) {height = 100;}
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch(type){
            case "Helicopter":
                return new Helicopter(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            case "Baloon":
                return new Baloon(name, coordinates);
        }
        System.out.println("'" + type + "'" + " is not a valid aircraft and has not been registered!");
        System.out.println("Next time specify one of these types: 'Helicopter', 'Jetplane', or 'Baloon'");
        return new Baloon();
    }

}