package avaj_launcher.weather;

import java.util.Random;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public class WeatherProvider{

    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG", "SNOW", "SUN"};

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        if (weatherProvider == null){
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random();
        int randomElement = rand.nextInt(weather.length);
        return weather[randomElement];
    }

}