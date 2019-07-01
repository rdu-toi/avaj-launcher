package avaj_launcher.flyable;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    Baloon(){};

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    };

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        switch(weather){
            case "RAIN":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : Quick, grab your jacket!");
                coordinates.setLongitude(5);
                break;
            case "FOG":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : Either that's slender man or a tree. In any case we're gonna crash!");
                coordinates.setLatitude(1);
                break;
            case "SNOW":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : Brrrr. I can't feel my face!");
                coordinates.setHeight(-12);
                break;
            case "SUN":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : This is beautiful weather, wish I brought sun screen though.");
                coordinates.setLongitude(10);
                coordinates.setHeight(2);
                break;
        }

        if (this.getCoordinates().getHeight() <= 0){
            System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " landing.");
            this.weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        System.out.println("Tower says: " + getType() + "#" + getName() + "(" + getId() + ")" + " registered to weather tower.");
        this.weatherTower.register(this);
    }

    public String getType(){
        return "Baloon";
    }

}