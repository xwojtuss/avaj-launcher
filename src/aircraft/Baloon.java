package aircraft;

import parser.Coordinates;
import aircraft.Aircraft;
import weather.WeatherProvider;
import logger.Logger;

public class Baloon extends Aircraft {
    public  Baloon(long p_id, String p_name, Coordinates p_coordinate) {
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
                this.coordinates.add(2, 0, 4);
                message = "I will get sunburnt!!!! My ballon is really sensitive! HELP!";
                break;
            case "RAIN":
                this.coordinates.add(0, 0, -5);
                message = "There's radioactive rain falling on me!! HELP ME PLEASE!";
                break;
            case "FOG":
                this.coordinates.add(0, 0, -3);
                message = "I cannot see anything!!! Am I blind? DID I JUST GO BLIND?!?!?!";
                break;
            case "SNOW":
                this.coordinates.add(0, 0, -15);
                message = "OH GOD THERE'S A HAILSTORM HERE!! Oh wait it's just snow.";
                break;
        }
        if (message != null)
            Logger.getInstance().logWeatherChange(this, message);
        if (this.coordinates.getHeight() <= 0) {
            Logger.getInstance().logWeatherChange(this, "Oh NOOO!!! I am falling!!!");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public String   toString() {
        return "Baloon#" + this.name + "(" + this.id + ")";
    }
}