package aircraft;

import parser.Coordinates;
import aircraft.Aircraft;
import weather.WeatherProvider;
import logger.Logger;

public class JetPlane extends Aircraft {
    public  JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    public void updateConditions() {
        String  weather = WeatherProvider.getInstance().getCurrentWeather(this.coordinates);
        String  message = null;

        switch (weather) {
            case "SUN":
                this.coordinates.add(0, 10, 2);
                message = "OMG it's so hot, I could literally die rn.";
                break;
            case "RAIN":
                this.coordinates.add(0, 5, 0);
                message = "All this rain makes me want a pumpkin spice latte.";
                break;
            case "FOG":
                this.coordinates.add(0, 1, 0);
                message = "OMFG look at the fog, that's soooooo crazy.";
                break;
            case "SNOW":
                this.coordinates.add(0, 0, -7);
                message = "It's, like, seriously, like, blasting snow rn.";
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            Logger.getInstance().logWeatherChange(this, "Damnnnn... I'm landinggg.");
            this.weatherTower.unregister(this);
        } else if (message != null)
            Logger.getInstance().logWeatherChange(this, message);
    }

    @Override
    public String   toString() {
        return "JetPlane#" + this.name + "(" + this.id + ")";
    }
}