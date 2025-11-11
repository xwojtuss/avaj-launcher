package tower;

import weather.WeatherProvider;
import tower.Tower;
import parser.Coordinates;

public class WeatherTower extends Tower {
    public String   getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        this.conditionChanged();
    }
}