package avaj_launcher.flyable;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public class JetPlane extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    JetPlane(){};

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    };

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        switch(weather){
            case "RAIN":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : Why'd they make me fly in a storm.");
                coordinates.setLongitude(5);
                break;
            case "FOG":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : Gotta slow down, I'm blind in this fog.");
                coordinates.setLatitude(1);
                break;
            case "SNOW":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : Turning on the AC, it's freezing!");
                coordinates.setHeight(-12);
                break;
            case "SUN":
                System.out.println(getType() + "#" + getName() + "(" + getId() + ")" + " : The freedom of roaming the clear blue sky, I love my job!");
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
        return "JetPlane";
    }

}