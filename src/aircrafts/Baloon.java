package src.aircrafts;
import src.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    public Baloon(int p_id,String name, Coordinates coordinates) {
        super(p_id, name, coordinates);
        super.type = "Baloon";
    }
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
                break;
            case "RAIN":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
                break;
            case "FOG":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
                break;
            case "SNOW":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("Baloon#" + this.name + "(" + this.id + "): landing at" + this.coordinates.getLongitude() + " " + this.coordinates.getLatitude() + " " + this.coordinates.getHeight() + ".");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower going " + this.coordinates.getLongitude() + " " + this.coordinates.getLatitude() + " " + this.coordinates.getHeight() + ".");
    }
}
