package avaj_launcher.flyable;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public class Helicopter extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    Helicopter(){};

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    };

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        switch(weather){
            case "RAIN":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : Close the door, I'm raining wet!");
                coordinates.setLongitude(5);
                break;
            case "FOG":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : Even with the spotlight, I can't see a thing!");
                coordinates.setLatitude(1);
                break;
            case "SNOW":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : It's so cold. Pour us a cup'o'java will ya.");
                coordinates.setHeight(-12);
                break;
            case "SUN":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : Put on your sunglasses folks.");
                coordinates.setLongitude(10);
                coordinates.setHeight(2);
                break;
        }

        if (this.getCoordinates().getHeight() <= 0){
            System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: " + getType() + "#" + getName() + "(" + getId() + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        System.out.println("Tower says: " + getType() + "#" + getName() + "(" + getId() + ")" + " registered to weather tower.");
        this.weatherTower.register(this);
    }

    public String getType(){
        return "Helicopter";
    }

}