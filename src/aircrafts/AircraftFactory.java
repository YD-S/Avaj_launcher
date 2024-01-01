package src.aircrafts;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height, int[] id) {
        type = type.toLowerCase();
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "baloon":
                return new Baloon(id[0], name, coordinates);
            case "helicopter":
                return new Helicopter(id[1], name, coordinates);
            case "jetplane":
                return new JetPlane(id[2], name, coordinates);
            default:
                throw new IllegalArgumentException("Invalid aircraft type: " + type);
        }
    }
}
