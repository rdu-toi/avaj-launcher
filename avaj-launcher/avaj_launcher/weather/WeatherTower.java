package avaj_launcher.weather;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        this.conditionsChanged();
    }

    public void getChangeWeather(){
        this.changeWeather();
    }

}