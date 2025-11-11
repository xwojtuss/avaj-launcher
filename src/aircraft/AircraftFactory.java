package aircraft;

import parser.Coordinates;
import aircraft.Flyable;
import aircraft.Baloon;
import aircraft.Helicopter;
import aircraft.JetPlane;
import exceptions.InvalidAircraft;

public class AircraftFactory {
    private static AircraftFactory  instance;
    private long                    nextId;

    private AircraftFactory() {}

    public static AircraftFactory   getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
            instance.nextId = 1;
        }
        return instance;
    }

    public Flyable  newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws InvalidAircraft {
        switch (p_type) {
            case "Baloon":
                return new Baloon(instance.nextId++, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(instance.nextId++, p_name, p_coordinates);
            case "Helicopter":
                return new Helicopter(instance.nextId++, p_name, p_coordinates);
            default:
                throw new InvalidAircraft("Invalid mode of aircraft");
        }
    }
}