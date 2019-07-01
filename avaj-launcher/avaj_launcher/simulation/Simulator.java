package avaj_launcher.simulation;

import java.util.*;
import java.io.*;
import java.lang.Object;
import java.lang.ArrayIndexOutOfBoundsException;

import avaj_launcher.flyable.*;
import avaj_launcher.weather.*;

public class Simulator{
    private static WeatherTower weatherTower;

    public static void main(String[] args){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null){
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0){
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null){
                    AircraftFactory af = new AircraftFactory();
                    Flyable flyable = af.newAircraft(line.split(" ")[0], line.split(" ")[1],
                    Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
                    if (flyable.getCoordinates() != null)
                        flyable.registerTower(weatherTower);
                }
                for (int i = 0; i < simulations; i++){
                    weatherTower.getChangeWeather();
                }
                reader.close();
            }
        } catch (FileNotFoundException e){
            System.out.println("Couldn't find file " + args[0]);
        } catch (IOException e){
            System.out.println("There was an error while reading the file " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Specify simulation file");
        // } finally{
        //     Logger.getLogger(null);
        }
    }

}