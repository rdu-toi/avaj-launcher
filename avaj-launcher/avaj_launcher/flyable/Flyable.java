package avaj_launcher.flyable;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public interface Flyable{

    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    public Coordinates getCoordinates();
    
}