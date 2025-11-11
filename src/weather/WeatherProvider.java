package weather;

import parser.Coordinates;

public class WeatherProvider {
    private String[]                weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider  instance;

    private WeatherProvider() {}

    public static WeatherProvider   getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String  getCurrentWeather(Coordinates p_coordinates) {
        long    sum = p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude();

        return instance.weather[(int)(sum % instance.weather.length)];
    }
}