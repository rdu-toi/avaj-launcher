package avaj_launcher.flyable;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    public Aircraft(){}

    protected Aircraft(String name, Coordinates coordinates){
        this.setName(name);
        this.setCoordinates(coordinates);
        this.id = nextId();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    private static long nextId(){
        idCounter++;
        return idCounter;
    }
}