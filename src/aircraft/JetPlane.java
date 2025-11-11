package aircraft;

import parser.Coordinates;
import aircraft.Aircraft;

public class JetPlane extends Aircraft {
    public  JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    public void updateConditions() {
        
    }

    @Override
    public String   toString() {
        return "JetPlane#" + this.name + "(" + this.id + ")";
    }
}