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
        long    sum = (long)(p_coordinates.getHeight() * 1.5) + (long)(p_coordinates.getLatitude() * 1.5) + (long)(p_coordinates.getLongitude() * 1.5);

        return instance.weather[(int)(sum % instance.weather.length)];
    }
}