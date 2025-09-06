package src.aircrafts;
import src.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(int p_id, String name, Coordinates coordinates) {
        super(p_id, name, coordinates);
        super.type = "Helicopter";
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                System.out.println("Helicopter#" + name + "(" + id + "): This is hot.");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                System.out.println("Helicopter#" + name + "(" + id + "): It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                System.out.println("Helicopter#" + name + "(" + id + "): I can't see anything.");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                System.out.println("Helicopter#" + name + "(" + id + "): My rotor is going to freeze!");
                break;
        }
        if (coordinates.getHeight() <= 0) {
            System.out.println("Helicopter#" + name + "(" + id + "): landing at" + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight() + ".");
            weatherTower.unregister(this);
            System.out.println("Tower says: Helicopter#" + name + "(" + id + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: Helicopter#" + name + "(" + id + ")" + " registered to weather tower going " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight() + ".");
    }
}
