package src.aircrafts;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        type = type.toLowerCase();
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "baloon":
                return new Baloon(name, coordinates);
            case "helicopter":
                return new Helicopter(name, coordinates);
            case "jetplane":
                return new JetPlane(name, coordinates);
            default:
                throw new IllegalArgumentException("Invalid aircraft type: " + type);
        }
    }
}
