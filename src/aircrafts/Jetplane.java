package src.aircrafts;
import src.WeatherTower;

public class Jetplane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Jetplane(long p_id, String name, Coordinates coordinates){
        super(p_id, name, coordinates);
        super.type = "Jetplane";
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        switch (weather){
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                System.out.println("Jetplane#" + name + "(" + id + "): This is hot.");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                System.out.println("Jetplane#" + name + "(" + id + "): It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                System.out.println("Jetplane#" + name + "(" + id + "): I can't see anything.");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                System.out.println("Jetplane#" + name + "(" + id + "): OMG! Winter is coming!");
                break;
        }
        if (coordinates.getHeight() == 0){
            System.out.println("Jetplane#" + name + "(" + id + "): landing at" + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight() + ".");
            weatherTower.unregister(this);
            System.out.println("Tower says: Jetplane#" + name + "(" + id + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: Jetplane#" + name + "(" + id + ")" + " registered to weather tower going " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight() + ".");
    }
}
