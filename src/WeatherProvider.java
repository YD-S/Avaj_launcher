package src;
import java.util.Random;
import src.aircrafts.Coordinates;

public class WeatherProvider {
    static private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider weatherProvider;
    private WeatherProvider() {}
    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }
    public static String getCurrentWeather(Coordinates p_coordinates) {
        int seed = p_coordinates.getLongitude() * p_coordinates.getLatitude() * p_coordinates.getHeight();
        seed += new Random().nextInt(100);
        return weather[seed % 4];
    }

}
