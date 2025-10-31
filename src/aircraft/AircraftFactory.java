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

    public AircraftFactory() {
        if (this.instance == null) {
            this.instance = new AircraftFactory();
            this.instance.nextId = 0;
        }
    }

    public Flyable  newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws InvalidAircraft {
        switch (p_type) {
            case "Baloon":
                return new Baloon(nextId++, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(nextId++, p_name, p_coordinates);
            case "Helicopter":
                return new Helicopter(nextId++, p_name, p_coordinates);
            default:
                throw new InvalidAircraft("Invalid mode of aircraft");
        }
    }
}