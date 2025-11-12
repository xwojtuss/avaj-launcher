package aircraft;

import parser.Coordinates;
import aircraft.Aircraft;
import weather.WeatherProvider;
import logger.Logger;

public class Helicopter extends Aircraft {
    public  Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
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
                this.coordinates.add(10, 0, 2);
                message = "Wow! The weather is almost as hot as Wojtek!";
                break;
            case "RAIN":
                this.coordinates.add(5, 0, 0);
                message = "Wow! The rain looks pretty!";
                break;
            case "FOG":
                this.coordinates.add(1, 0, 0);
                message = "Wow! The fog is co climatic!";
                break;
            case "SNOW":
                this.coordinates.add(0, 0, -12);
                message = "Wow! The snow makes me want to build a snowman!";
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            Logger.getInstance().logWeatherChange(this, "Wow! The ground is getting really close!");
            this.weatherTower.unregister(this);
        } else if (message != null)
            Logger.getInstance().logWeatherChange(this, message);
    }

    @Override
    public String   toString() {
        return "Helicopter#" + this.name + "(" + this.id + ")";
    }
}