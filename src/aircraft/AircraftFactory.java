package aircraft;

import parser.Coordinates;
import aircraft.Flyable;

public class AircraftFactory {
    private static AircraftFactory  instance;
    private long                    nextId;

    public AircraftFactory() {
        if (this.instance == null) {
            this.instance = new AircraftFactory();
            this.instance.nextId = 0;
        }
    }

    // public Flyable  newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
    //     switch (p_type) {
    //         case "Baloon":
    //             break;
    //         case "JetPlane":
    //             break;
    //         case "Helicopter":
    //             break;
    //     }
    // }
}